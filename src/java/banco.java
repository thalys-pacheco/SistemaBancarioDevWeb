import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/banco"})
public class banco extends HttpServlet {

    void getHeader(){
        
    }
    request
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String nome = request.getParameter("nome");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet banco</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet banco at "+ nome +"</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
