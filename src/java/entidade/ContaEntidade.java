package entidade;

import java.util.HashMap;
import java.util.Map;

public class ContaEntidade {    
    private final int id;
    private final int idUsuario;
    private final String tipo;
    private double  saldo;
    
    public ContaEntidade(int id, int idUsuario,String tipo){
        this.id = id;
        this.idUsuario = idUsuario;
        this.tipo = tipo;
        this.saldo = 0.0;
    }
    
    public Map<String, Object> getDadosConta(){
        Map<String, Object> dados = new HashMap();
        
        dados.put("id", id);
        dados.put("idUsuario", idUsuario);
        dados.put("tipo", tipo);
        dados.put("saldo", saldo);
        
        return(dados);
    }
    
    public void deposito(double valor){
        saldo = saldo + valor;
    }
    
    public void saque (double valor){
        saldo = saldo - valor;
    }
}
