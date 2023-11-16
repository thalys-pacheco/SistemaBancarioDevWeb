import provider.TransacaoProvider;
import entidade.TransacaoEntidade;
import provider.ContaProvider;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/transacao"})
public class transacao extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        int idConta = Integer.parseInt(request.getParameter("idConta"));
        
        List<TransacaoEntidade> transacoes = TransacaoProvider.getTransacoes( idConta);
        request.setAttribute("transacoes", transacoes);
        
        RequestDispatcher rd = request.getRequestDispatcher("/pages/login/index.jsp");
        rd.forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String tipo = request.getParameter("tipo");
        int idConta = Integer.parseInt(request.getParameter("idConta"));
        double valor = Double.parseDouble(request.getParameter("valor"));
        
        switch(tipo){
            case "Deposito":
                TransacaoProvider.deposito( idConta, valor);
                ContaProvider.deposito(idConta,valor);
                break;
            case "Saque":
                TransacaoProvider.saque(idConta, valor);
                ContaProvider.saque(idConta,valor);
                break;
            case "Transferencia":
                int idDestinatario = Integer.parseInt(request.getParameter("idDestinatario"));
                TransacaoProvider.transferencia( idConta, idDestinatario,valor);
                ContaProvider.saque(idConta,valor);
                ContaProvider.deposito(idDestinatario,valor);
                break;
        }
        
        RequestDispatcher rd = request.getRequestDispatcher("/pages/home/index.jsp");
        rd.forward(request, response);
        
    }
}
