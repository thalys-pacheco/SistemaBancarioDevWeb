import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/login"})
public class login extends HttpServlet {    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String cpf = request.getParameter("cpf");
        String password = request.getParameter("password");
        if(cpf.isEmpty() || password.isEmpty()){
            RequestDispatcher rd = request.getRequestDispatcher("/pages/login");
            rd.forward(request, response);
        }else if("11111111111".equals(cpf)){
            RequestDispatcher rd = request.getRequestDispatcher("/pages/admin");
            rd.forward(request, response);
        }else if("22222222222".equals(cpf)){
            RequestDispatcher rd = request.getRequestDispatcher("/pages/home");
            rd.forward(request, response);
        }else{
            RequestDispatcher rd = request.getRequestDispatcher("/pages/login");
            rd.forward(request, response);
        }
    }
}
