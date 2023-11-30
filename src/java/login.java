import entidade.UsuarioEntidade;
import entidade.ContaEntidade;
import model.ContaDAO;
import model.UsuarioDAO;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/login"})
public class login extends HttpServlet {  
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        request.getSession().invalidate();
        RequestDispatcher rd = request.getRequestDispatcher("/views/login/index.jsp");
        rd.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String cpf = request.getParameter("cpf");
        String password = request.getParameter("password");
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        if(cpf.isEmpty() || password.isEmpty()){
            RequestDispatcher rd = request.getRequestDispatcher("/views/login/index.jsp");
            rd.forward(request, response);
        }else{
            UsuarioEntidade usuario = usuarioDAO.logar(cpf, password);
            if(usuario!=null){
               
                HttpSession session = request.getSession();
                session.setAttribute("usuario",usuario);

                if("admin".equals(usuario.getTipo())){
                    RequestDispatcher rd = request.getRequestDispatcher("/views/admin/index.jsp");
                    rd.forward(request, response);
                    
                }else{
                    ContaDAO contaDAO = new ContaDAO();
                    List<ContaEntidade> contas = contaDAO.getContasByUser(usuario.getId());
                    session.setAttribute("contas",contas);

                    RequestDispatcher rd = request.getRequestDispatcher("/views/home/index.jsp");
                    rd.forward(request, response);
                    }

                
            }else{
                RequestDispatcher rd = request.getRequestDispatcher("/views/login/index.jsp");
                rd.forward(request, response);
            }
        }
    }
}
