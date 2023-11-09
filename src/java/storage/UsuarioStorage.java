package storage;

import models.UsuarioModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UsuarioStorage {    
    private final List<UsuarioModel> listaUsuarios;
    
    public UsuarioStorage(){
        this.listaUsuarios = new ArrayList<>();
    }
    
    public void addUsuario(UsuarioModel usuario){
        listaUsuarios.add(usuario);
    }
    
    public int getTamanho(){
        return listaUsuarios.size();
    }
    
    public UsuarioModel getUsuario(String cpf){
        
        for (UsuarioModel usuario : listaUsuarios) {
            Map<String, Object> dados = usuario.getDadosUsuario();
            if(cpf.equals(dados.get("cpf"))){
                return(usuario);
            }
        }
        return null;
    }
}
