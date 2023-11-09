package provider;

import models.UsuarioModel;
import storage.UsuarioStorage;

public class UsuarioProvider {

    static public UsuarioStorage usuarioStorage = new UsuarioStorage();
    
    static public void addUsuario(UsuarioModel usuario){
        usuarioStorage.addUsuario(usuario);
    }
    
    static public int getTamanho(){
        return usuarioStorage.getTamanho();
    }
    
    static public UsuarioModel getUsuario(String cpf){
        return usuarioStorage.getUsuario(cpf);
    }
}