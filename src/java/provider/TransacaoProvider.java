package provider;

import java.util.List;
import entidade.TransacaoEntidade;
import storage.TransacaoStorage;

public class TransacaoProvider {

    static public TransacaoStorage transacaoStorage = new TransacaoStorage();
    
    static public void deposito(int idConta, double valor){
        int id = transacaoStorage.getTamanho();
        TransacaoEntidade transacao = new TransacaoEntidade(id, -1, idConta, valor);
        transacaoStorage.addTransacao(transacao);
    }
    
    static public void saque(int idConta, double valor){
        int id = transacaoStorage.getTamanho();
        TransacaoEntidade transacao = new TransacaoEntidade(id, idConta, -1, valor);
        transacaoStorage.addTransacao(transacao);
    }
    
    static public void transferencia(int idConta, int idDestinatario, double valor){
        int id = transacaoStorage.getTamanho();
        TransacaoEntidade transacao = new TransacaoEntidade(id, idConta, idDestinatario, valor);
        transacaoStorage.addTransacao(transacao);
    }
    
    static public int getTamanho(){
        return transacaoStorage.getTamanho();
    }
    
    static public List<TransacaoEntidade> getTransacoes(int id){
        return transacaoStorage.getTransacoes(id);
    }
}