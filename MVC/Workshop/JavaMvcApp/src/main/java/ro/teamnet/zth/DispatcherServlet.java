package ro.teamnet.zth;

import ro.teamnet.zth.api.annotations.MyController;
import ro.teamnet.zth.api.annotations.MyRequestMethod;
import ro.teamnet.zth.appl.controller.DepartmentController;
import ro.teamnet.zth.appl.controller.EmployeeController;
import ro.teamnet.zth.fmk.AnnotationScanUtils;
import ro.teamnet.zth.fmk.MethodAttributes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by user on 7/14/2016.
 */
public class DispatcherServlet extends HttpServlet {

    /**
     * key: urlPath
     * val: method info
     */
    Map<String, MethodAttributes> allowedMethods = new HashMap<String, MethodAttributes>();

    @Override
    public void init() throws ServletException {

        try {
            Iterable<Class> controllers = AnnotationScanUtils.getClasses("ro.teamnet.zth.appl.controller");
            for (Class controller : controllers)
                if (controller.isAnnotationPresent(MyController.class)) {
                    MyController myControllerAnnotation =
                            (MyController) controller.getAnnotation(MyController.class);
                    String controllerUrlPath = myControllerAnnotation.urlPath();
                    Method[] methods = controller.getMethods();

                    for (Method controllerMethod : methods) {
                        if (controllerMethod.isAnnotationPresent(MyRequestMethod.class)) {
                            MyRequestMethod myRequestMethod =
                                    controllerMethod.getAnnotation(MyRequestMethod.class);
                            String methodUrlPath = myRequestMethod.urlPath();
                            // build hashmap key
                            String urlPath = controllerUrlPath + methodUrlPath;

                            // build hashmap value
                            MethodAttributes methodAttributes = new MethodAttributes();
                            methodAttributes.setControllerClass(controller.getName());
                            methodAttributes.setMethodType(myRequestMethod.methodType());
                            methodAttributes.setMethodName(controllerMethod.getName());

                            // add to map
                            allowedMethods.put(urlPath, methodAttributes);
                        }
                    }
                }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        dispatchReply("GET", req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        dispatchReply("POST", req, resp);

    }

    protected void dispatchReply(String type, HttpServletRequest req, HttpServletResponse resp) {

        Object r = null;
        try {
            r = dispatch(req, resp);
            reply(r, req, resp);
        } catch (Exception e) {
            sendExceptionError(e, req, resp);
        }
    }

    private void sendExceptionError(Exception e, HttpServletRequest req, HttpServletResponse resp) {

    }

    private void reply(Object r, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().printf(r.toString());
    }

    private Object dispatch(HttpServletRequest req, HttpServletResponse resp) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        String pathInfo = req.getPathInfo();

        MethodAttributes methodAttributes = allowedMethods.get(pathInfo);
        Object controller = Class.forName(methodAttributes.getControllerClass()).newInstance();
        return controller.getClass().getMethod(methodAttributes.getMethodName()).invoke(controller);
    }
}
