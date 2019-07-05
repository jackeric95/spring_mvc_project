package cc.openhome;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@MultipartConfig
@WebServlet("/upload") 
public class Upload extends HttpServlet { 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         request.setCharacterEncoding("UTF-8"); // 為了處理中文檔名

         request.getParts()
                .stream()
                .filter(part -> !"upload".equals(part.getName()))
                .forEach(this::write);
    }

    private void write(Part part) {
        String filename = part.getSubmittedFileName();
        try(InputStream in = part.getInputStream();  
            OutputStream out = new FileOutputStream("c:/workspace/" + filename)) {
            byte[] buffer = new byte[1024];
            int length = -1;
            while ((length = in.read(buffer)) != -1) {
                out.write(buffer, 0, length);
            }
        } catch(IOException ex) {
            throw new UncheckedIOException(ex);
        }
    }
}