package entidade;

import java.util.HashMap;
import java.util.Map;

public class ContaEntidade {    
    private int id;
    private int idUsuario;
    private String tipo;
    private double  saldo;
    
    public ContaEntidade( int idUsuario,String tipo, double saldo){
        this.idUsuario = idUsuario;
        this.tipo = tipo;
        this.saldo = saldo;
    }
    
    public Map<String, Object> getDadosConta(){
        Map<String, Object> dados = new HashMap();
        
        dados.put("id", getId());
        dados.put("idUsuario", getIdUsuario());
        dados.put("tipo", getTipo());
        dados.put("saldo", getSaldo());
        
        return(dados);
    }
    
    public void deposito(double valor){
        setSaldo(getSaldo() + valor);
    }
    
    public void saque (double valor){
        setSaldo(getSaldo() - valor);
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
     * @return the idUsuario
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the saldo
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    
}
