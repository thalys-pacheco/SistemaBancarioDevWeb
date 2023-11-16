package entidade;

import java.util.HashMap;
import java.util.Map;

public class TransacaoEntidade {    
    private final int id;
    private final int idEmissor;
    private final int idDestinatario;
    private final double valor;
    
    public TransacaoEntidade(int id, int idEmissor, int idDestinatario, double valor){
        this.id = id;
        this.idEmissor = idEmissor;
        this.idDestinatario = idDestinatario;
        this.valor = valor;
    }
    
    public Map<String, Object> getDadosTransacao(){
        Map<String, Object> dados = new HashMap();
        
        dados.put("id", id);
        dados.put("idDestinatario", idDestinatario);
        dados.put("idEmissor", idEmissor);
        dados.put("valor", valor);
        
        return(dados);
    }
}
