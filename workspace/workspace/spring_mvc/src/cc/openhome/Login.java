package cc.openhome;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/login")
public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
                      throws ServletException, IOException {
        String name = request.getParameter("name");
        String passwd = request.getParameter("passwd");
        if("caterpillar".equals(name) && "123456".equals(passwd)) {
            if(request.getSession(false) != null) {
                request.changeSessionId();
            }
            request.getSession().setAttribute("login", name);
            response.sendRedirect("user");
        }
        else {
            response.sendRedirect("login.jsp");
        }
    }
} 