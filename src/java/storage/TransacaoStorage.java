package storage;

import java.util.ArrayList;
import entidade.TransacaoEntidade;
import java.util.List;
import java.util.Map;

public class TransacaoStorage {    
    private final List<TransacaoEntidade> listaTransacao;
    
    public TransacaoStorage(){
        this.listaTransacao = new ArrayList<>();
    }
    
    public void addTransacao(TransacaoEntidade conta){
        listaTransacao.add(conta);
    }
    
    public int getTamanho(){
        return listaTransacao.size();
    }
    
    public List<TransacaoEntidade> getTransacoes(int idConta){
        List<TransacaoEntidade> listaTransacoesConta = new ArrayList<>();
        
        for (TransacaoEntidade transacao : listaTransacao) {
            Map<String, Object> dados = transacao.getDadosTransacao();
            if(idConta == (int) dados.get("idEmissor") || idConta == (int) dados.get("idDestinatario")){
                listaTransacoesConta.add(transacao);
            }
        }
        
        return(listaTransacoesConta);
    }
}
