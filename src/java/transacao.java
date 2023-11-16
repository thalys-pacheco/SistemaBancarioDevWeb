import models.UsuarioModel;
import provider.UsuarioProvider;
import provider.ContaProvider;

import java.io.IOException;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.ContaModel;

@WebServlet(urlPatterns = {"/conta"})
public class conta extends HttpServlet {    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String cpf = request.getParameter("cpf");
        String tipo = request.getParameter("tipo");
        if(cpf.isEmpty() || tipo.isEmpty()){
            RequestDispatcher rd = request.getRequestDispatcher("/pages/cadConta/index.jsp");
            rd.forward(request, response);
        }else{
            UsuarioModel usuario = UsuarioProvider.getUsuario(cpf);
            if(usuario!=null){
                Map<String, Object> dados = usuario.getDadosUsuario();
                if("cliente".equals(dados.get("tipo"))){
                    int id = ContaProvider.getTamanho();
                    ContaModel conta = new ContaModel(id, (int) dados.get("id") ,tipo);
                    ContaProvider.addConta(conta);
                    RequestDispatcher rd = request.getRequestDispatcher("/pages/admin/index.jsp");
                    rd.forward(request, response);
                }else{
                    RequestDispatcher rd = request.getRequestDispatcher("/pages/cadConta/index.jsp");
                    rd.forward(request, response);
                }
            }else{
                RequestDispatcher rd = request.getRequestDispatcher("/pages/cadConta/index.jsp");
                rd.forward(request, response);
            }  
        }
    }
}
