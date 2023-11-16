package provider;

import entidade.UsuarioEntidade;
import storage.UsuarioStorage;

public class UsuarioProvider {

    static public UsuarioStorage usuarioStorage = new UsuarioStorage();
    
    static public void addUsuario(UsuarioEntidade usuario){
        usuarioStorage.addUsuario(usuario);
    }
    
    static public int getTamanho(){
        return usuarioStorage.getTamanho();
    }
    
    static public UsuarioEntidade getUsuario(String cpf){
        return usuarioStorage.getUsuario(cpf);
    }
}