import entidade.UsuarioEntidade;
import provider.UsuarioProvider;


import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.UsuarioDAO;

@WebServlet(urlPatterns = {"/usuario"})
public class usuario extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String tipo = request.getParameter("tipo");
        String cpf = request.getParameter("cpf");
        String email = request.getParameter("email");
        if(cpf.isEmpty() || email.isEmpty() || nome.isEmpty()){
            RequestDispatcher rd = request.getRequestDispatcher("/pages/cadUsuario/index.jsp");
            rd.forward(request, response);
        }else{
            int id = UsuarioProvider.getTamanho();
            UsuarioEntidade usuario = new UsuarioEntidade(nome,tipo, cpf,email);
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            usuarioDAO.insert(usuario);
            RequestDispatcher rd = request.getRequestDispatcher("/pages/admin/index.jsp");
            rd.forward(request, response);
        }
    }
}