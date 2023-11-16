package entidade;

import java.util.HashMap;
import java.util.Map;

public class UsuarioEntidade {    
    private final int id;
    private final String nome;
    private final String tipo;
    private final String senha;
    private final String cpf;
    private final String email;
    
    public UsuarioEntidade(int id, String nome, String tipo,String cpf,String email){
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.senha = "123";
        this.cpf = cpf;
        this.email = email;
    }
    
    public Map<String, Object> getDadosUsuario(){
        Map<String, Object> dados = new HashMap();
        
        dados.put("id", id);
        dados.put("nome", nome);
        dados.put("tipo", tipo);
        dados.put("senha", senha);
        dados.put("cpf", cpf);
        dados.put("email", email);
        
        return(dados);
    }
}
