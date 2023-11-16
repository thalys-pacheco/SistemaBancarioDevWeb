package storage;

import entidade.UsuarioEntidade;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UsuarioStorage {    
    private final List<UsuarioEntidade> listaUsuarios;
    
    public UsuarioStorage(){
        this.listaUsuarios = new ArrayList<>();
    }
    
    public void addUsuario(UsuarioEntidade usuario){
        listaUsuarios.add(usuario);
    }
    
    public int getTamanho(){
        return listaUsuarios.size();
    }
    
    public UsuarioEntidade getUsuario(String cpf){
        
        for (UsuarioEntidade usuario : listaUsuarios) {
            Map<String, Object> dados = usuario.getDadosUsuario();
            if(cpf.equals(dados.get("cpf"))){
                return(usuario);
            }
        }
        return null;
    }
}
