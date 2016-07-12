package ro.teamnet.zth.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
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

        Enumeration headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = req.getHeader(key);
            map.put(key, value);
        }
        StringBuilder table = new StringBuilder();
        table.append("<table> <tr>");
        for(String s : map.keySet()){
            table.append("<th>" + s + "</th>");
        }
        table.append("</tr>");
        for(String s : map.keySet()){
            table.append("<td>" + map.get(s) + "</td>");
        }
        table.append("</table>");

        PrintWriter out = resp.getWriter();
        out.write(table.toString());


    }

}
