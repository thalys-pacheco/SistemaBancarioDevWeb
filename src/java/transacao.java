import entidade.ContaEntidade;
import entidade.TransacaoEntidade;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.ContaDAO;
import model.TransacaoDAO;

@WebServlet(urlPatterns = {"/transacao"})
public class transacao extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        int idConta = Integer.parseInt(request.getParameter("idConta"));
        
        TransacaoDAO transacaoDAO = new TransacaoDAO();
        List<TransacaoEntidade> transacoes = transacaoDAO.getTransacoesByConta(idConta);
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
        TransacaoDAO transacaoDAO = new TransacaoDAO();
        ContaDAO contaDAO = new ContaDAO();
        
        switch(tipo){
            case "Deposito":
                
                TransacaoEntidade transacaoDeposito = new TransacaoEntidade(-1, idConta, valor);
                
                transacaoDAO.insert(transacaoDeposito);
                
                
                ContaEntidade contaDeposito =  contaDAO.get(idConta);
                double novoSaldoDeposito = contaDeposito.getSaldo() + valor;
                contaDeposito.setSaldo(novoSaldoDeposito);      
                contaDAO.update(contaDeposito);
                break;
                
            case "Saque":
                ContaEntidade contaSaque =  contaDAO.get(idConta);
                double novoSaldoSaque = contaSaque.getSaldo() - valor;
                if(novoSaldoSaque < 0){
                    
                    RequestDispatcher rd = request.getRequestDispatcher("/pages/transacao/index.jsp?tipo=Saque&idConta=" + idConta);
                    rd.forward(request, response);
                    break;
                }
                TransacaoEntidade transacaoSaque = new TransacaoEntidade(idConta, -1, valor);
                transacaoDAO.insert(transacaoSaque);
                
                
                contaSaque.setSaldo(novoSaldoSaque); 
                contaDAO.update(contaSaque);
                break;
                
            case "Transferencia":
                int idDestinatario = Integer.parseInt(request.getParameter("idDestinatario"));

                TransacaoEntidade transacaoTransferencia = new TransacaoEntidade(idConta, idDestinatario, valor);
                transacaoDAO.insert(transacaoTransferencia);
                
                ContaEntidade contaEmissor =  contaDAO.get(idConta);
                ContaEntidade contaDestinatario =  contaDAO.get(idDestinatario);
                
                double novoSaldoEmissor = contaEmissor.getSaldo() - valor;
                double novoSaldoDestinatario = contaDestinatario.getSaldo() + valor;
                
                contaEmissor.setSaldo(novoSaldoEmissor);
                contaDestinatario.setSaldo(novoSaldoDestinatario);
                
                contaDAO.update(contaEmissor);
                contaDAO.update(contaDestinatario);
                break;
        }
        HttpSession session = request.getSession();
        List<ContaEntidade> contas = contaDAO.getContasByUser(idConta);
        session.setAttribute("contas",contas);
        RequestDispatcher rd = request.getRequestDispatcher("/pages/home/index.jsp");
        rd.forward(request, response);
        
    }
}
