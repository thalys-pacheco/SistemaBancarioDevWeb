package entidade;

import java.util.HashMap;
import java.util.Map;

public class UsuarioEntidade {    
    private int id;
    private String nome;
    private String tipo;
    private String senha;
    private String cpf;
    private String email;
    
    
    public UsuarioEntidade( String nome, String tipo,String cpf,String email){
        
        this.nome = nome;
        this.tipo = tipo;
        this.senha = "123";
        this.cpf = cpf;
        this.email = email;
    }
    
    
    public Map<String, Object> getDadosUsuario(){
        Map<String, Object> dados = new HashMap();
        
        dados.put("id", getId());
        dados.put("nome", getNome());
        dados.put("tipo", getTipo());
        dados.put("senha", getSenha());
        dados.put("cpf", getCpf());
        dados.put("email", getEmail());
        
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
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
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
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
