package ro.teamnet.zth.web;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 7/12/2016.
 */
public class InfoHttpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String, String> map = new HashMap<String, String>();
        Cookie[] arrayList = new Cookie[100];
        String[] parameterValues = new String[200];
        Enumeration parameterNames = req.getParameterNames();
        Enumeration headerNames = req.getHeaderNames();
        PrintWriter out = resp.getWriter();
        StringBuilder table = new StringBuilder();
        StringBuilder cookieTable = new StringBuilder();
        StringBuilder parameterTable = new StringBuilder();

        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = req.getHeader(key);
            map.put(key, value);
        }

        table.append("<table> <tr>");
        for(String s : map.keySet()){
            table.append("<th>" + s + "</th>");
        }
        table.append("</tr><tr>");
        for(String s : map.keySet()){
            table.append("<td>" + map.get(s) + "</td>");
        }
        table.append("</tr></table>\n");
        out.write(table.toString());

        out.write(req.getRequestURI() + "\n");
        out.write(req.getQueryString() + "\n");

        arrayList = req.getCookies();

        cookieTable.append("<table><tr>");
        for(Cookie cookie : arrayList){
            cookieTable.append("<td>" + cookie.toString() + "</td>");
        }
        cookieTable.append("</tr></table>\n");
        out.write(cookieTable.toString());

        parameterTable.append("<table> <tr>");
        while (parameterNames.hasMoreElements()){
            parameterTable.append("<td>" + parameterNames.nextElement().toString() + "</td>");
        }
        parameterTable.append("</tr><tr>");
        for(String s : parameterValues){
            parameterTable.append("<td>" + s + "</td>");
        }
        parameterTable.append("</tr></table>\n");

        out.write(parameterTable.toString());



    }

}
