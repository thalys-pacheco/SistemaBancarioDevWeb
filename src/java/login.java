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
        
        UsuarioEntidade adminDefault = new UsuarioEntidade(0,"Diego Admin","admin", "11111111111","diegoadmin@email.com");
        UsuarioProvider.addUsuario(adminDefault);
        
        UsuarioEntidade clientDefault = new UsuarioEntidade(1,"Diego Cliente","cliente", "22222222222","diegocliente@email.com");
        UsuarioProvider.addUsuario(clientDefault);
        
        ContaEntidade contaDefault = new ContaEntidade(0,1,"corrente");
        ContaProvider.addConta(contaDefault);
        
        UsuarioEntidade clientDefault2 = new UsuarioEntidade(2,"Diego Cliente2","cliente", "33333333333","diegocliente@email.com");
        UsuarioProvider.addUsuario(clientDefault2);
        
        ContaEntidade contaDefault2 = new ContaEntidade(0,2,"corrente");
        ContaProvider.addConta(contaDefault2);
    
        String cpf = request.getParameter("cpf");
        String password = request.getParameter("password");
        if(cpf.isEmpty() || password.isEmpty()){
            RequestDispatcher rd = request.getRequestDispatcher("/pages/login/index.jsp");
            rd.forward(request, response);
        }else{
            UsuarioEntidade usuario = UsuarioProvider.getUsuario(cpf);
            if(usuario!=null){
                Map<String, Object> dados = usuario.getDadosUsuario();
                if(password.equals(dados.get("senha"))){
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
            }else{
                RequestDispatcher rd = request.getRequestDispatcher("/pages/login/index.jsp");
                rd.forward(request, response);
            }
        }
    }
}
