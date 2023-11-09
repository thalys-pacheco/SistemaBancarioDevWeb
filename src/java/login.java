import models.UsuarioModel;
import provider.UsuarioProvider;
import models.ContaModel;
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

@WebServlet(urlPatterns = {"/login"})
public class login extends HttpServlet {    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        UsuarioModel adminDefault = new UsuarioModel(0,"Diego Admin","admin", "11111111111","diegoadmin@email.com");
        UsuarioProvider.addUsuario(adminDefault);
        
        UsuarioModel clientDefault = new UsuarioModel(1,"Diego Cliente","cliente", "22222222222","diegocliente@email.com");
        UsuarioProvider.addUsuario(clientDefault);
        
        ContaModel contaDefault = new ContaModel(0,1,"corrente");
        ContaProvider.addConta(contaDefault);
    
        String cpf = request.getParameter("cpf");
        String password = request.getParameter("password");
        if(cpf.isEmpty() || password.isEmpty()){
            RequestDispatcher rd = request.getRequestDispatcher("/pages/login/index.jsp");
            rd.forward(request, response);
        }else{
            UsuarioModel usuario = UsuarioProvider.getUsuario(cpf);
            if(usuario!=null){
                Map<String, Object> dados = usuario.getDadosUsuario();
                if(password.equals(dados.get("senha"))){

                    if("admin".equals(dados.get("tipo"))){
                        RequestDispatcher rd = request.getRequestDispatcher("/pages/admin/index.jsp");
                        rd.forward(request, response);
                    }else{
                        List<ContaModel> contas = ContaProvider.getContas((int) dados.get("id"));
                        request.setAttribute("usuario", usuario);
                        request.setAttribute("contas", contas);
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
