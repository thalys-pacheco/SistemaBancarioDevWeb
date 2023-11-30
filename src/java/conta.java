import entidade.UsuarioEntidade;
import model.UsuarioDAO;
import entidade.ContaEntidade;
import model.ContaDAO;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = {"/conta"})
public class conta extends HttpServlet {    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String cpf = request.getParameter("cpf");
        String tipo = request.getParameter("tipo");
        if(cpf.isEmpty() || tipo.isEmpty()){
            RequestDispatcher rd = request.getRequestDispatcher("/views/cadConta/index.jsp");
            rd.forward(request, response);
        }else{
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            UsuarioEntidade usuario = usuarioDAO.getByCpf(cpf);
            
            if(usuario!=null){
                
                if("cliente".equals(usuario.getTipo())){
                    
                    ContaEntidade conta = new ContaEntidade( usuario.getId() ,tipo, 0.0);
                    ContaDAO contaDAO = new ContaDAO();
                    contaDAO.insert(conta);
                    
                    RequestDispatcher rd = request.getRequestDispatcher("/views/admin/index.jsp");
                    rd.forward(request, response);
                }else{
                    RequestDispatcher rd = request.getRequestDispatcher("/views/cadConta/index.jsp");
                    rd.forward(request, response);
                }
            }else{
                RequestDispatcher rd = request.getRequestDispatcher("/views/cadConta/index.jsp");
                rd.forward(request, response);
            }  
        }
    }
}
