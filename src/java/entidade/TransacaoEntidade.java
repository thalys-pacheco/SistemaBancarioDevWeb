package entidade;

import java.util.HashMap;
import java.util.Map;

public class TransacaoEntidade {    
    private int id;
    private int idEmissor;
    private int idDestinatario;
    private double valor;
    
    public TransacaoEntidade(int idEmissor, int idDestinatario, double valor){
        this.idEmissor = idEmissor;
        this.idDestinatario = idDestinatario;
        this.valor = valor;
    }
    
    public Map<String, Object> getDadosTransacao(){
        Map<String, Object> dados = new HashMap();
        
        dados.put("id", getId());
        dados.put("idDestinatario", getIdDestinatario());
        dados.put("idEmissor", getIdEmissor());
        dados.put("valor", getValor());
        
        return(dados);
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the idEmissor
     */
    public int getIdEmissor() {
        return idEmissor;
    }

    /**
     * @param idEmissor the idEmissor to set
     */
    public void setIdEmissor(int idEmissor) {
        this.idEmissor = idEmissor;
    }

    /**
     * @return the idDestinatario
     */
    public int getIdDestinatario() {
        return idDestinatario;
    }

    /**
     * @param idDestinatario the idDestinatario to set
     */
    public void setIdDestinatario(int idDestinatario) {
        this.idDestinatario = idDestinatario;
    }

    /**
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
    }
    
    
}
