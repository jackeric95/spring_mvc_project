package cc.openhome;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/*")
public class Path extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("    <head>");
        out.println("        <title>Path Servlet</title>");
        out.println("    </head>");
        out.println("    <body>");
        out.println(request.getRequestURI() + "<br>");
        out.println(request.getContextPath() + "<br>");
        out.println(request.getServletPath() + "<br>");
        out.println(request.getPathInfo());
        out.println("    </body>");
        out.println("</html>");
    }
}