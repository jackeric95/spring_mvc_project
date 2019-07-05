package cc.openhome;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/push")
public class Push extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
                        throws ServletException, IOException {
        Optional.ofNullable(request.newPushBuilder())
                .ifPresent(pushBuilder -> {
                    pushBuilder.path("avatars/caterpillar.jpg")
                               .addHeader("content-type", "image/jpg")
                               .push();
                });

        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<body>");
        out.println("<img src='avatars/caterpillar.jpg'>");
        out.println("</body>");
        out.println("</html>");
    }
}