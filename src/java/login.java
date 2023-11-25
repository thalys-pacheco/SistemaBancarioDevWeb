import entidade.UsuarioEntidade;
import provider.UsuarioProvider;
import entidade.ContaEntidade;
import provider.ContaProvider;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.UsuarioDAO;

@WebServlet(urlPatterns = {"/login"})
public class login extends HttpServlet {  
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        request.getSession().invalidate();
        RequestDispatcher rd = request.getRequestDispatcher("/pages/login/index.jsp");
        rd.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        /*
        UsuarioEntidade adminDefault = new UsuarioEntidade("Diego Admin","admin", "11111111111","diegoadmin@email.com");
        adminDefault.setId(1);
        UsuarioProvider.addUsuario(adminDefault);
        */

    
        String cpf = request.getParameter("cpf");
        String password = request.getParameter("password");
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        if(cpf.isEmpty() || password.isEmpty()){
            RequestDispatcher rd = request.getRequestDispatcher("/pages/login/index.jsp");
            rd.forward(request, response);
        }else{
            UsuarioEntidade usuario = usuarioDAO.logar(cpf, password);
            if(usuario!=null){
                Map<String, Object> dados = usuario.getDadosUsuario();
               
                HttpSession session = request.getSession();
                session.setAttribute("usuario",usuario);

                if("admin".equals(dados.get("tipo"))){
                    RequestDispatcher rd = request.getRequestDispatcher("/pages/admin/index.jsp");
                    rd.forward(request, response);
                }else{
                    List<ContaEntidade> contas = ContaProvider.getContas((int) dados.get("id"));
                    session.setAttribute("contas",contas);

                    RequestDispatcher rd = request.getRequestDispatcher("/pages/home/index.jsp");
                    rd.forward(request, response);
                    }

                
            }else{
                RequestDispatcher rd = request.getRequestDispatcher("/pages/login/index.jsp");
                rd.forward(request, response);
            }
        }
    }
}
