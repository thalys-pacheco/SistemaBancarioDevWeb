package model;

import entidade.UsuarioEntidade;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class UsuarioDAO implements DAO<UsuarioEntidade>{    
    
    @Override
    public UsuarioEntidade get(int id) {
        
        UsuarioEntidade usuario;
        Conexao conexao = new Conexao();
        try{
            PreparedStatement sql = conexao.getConexao().prepareStatement("INSERT INTO usuarios (nome, tipo, senha, cpf, email)" +
            "VALUES(?, ?, ?, ?, ?) ");
            
            
            sql.setString(1, usuario);
            sql.setInt(1, id);
            ResultSet resultado = sql.executeQuery();
            
            
            if(resultado!=null){
                while(resultado.next()){
                    
                    String nome = (resultado.getString("NOME"));
                    String tipo = (resultado.getString("TIPO"));
                    String senha = (resultado.getString("SENHA"));
                    String cpf = (resultado.getString("CPF"));
                    String email = (resultado.getString("EMAIL"));
                    UsuarioEntidade usuario = new UsuarioEntidade(id, nome, tipo, cpf, email);
                    return usuario;
                }
            }
            return null;
            
        } catch (SQLException e) {
            throw new RuntimeException("Query de select (get usuario) incorreto");
        } finally{
            conexao.closeConexao();
        }
    }
    
}
