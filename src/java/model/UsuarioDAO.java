package model;

import entidade.UsuarioEntidade;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UsuarioDAO implements DAO<UsuarioEntidade>{    
    
    
    //inserindo usuario
    public void  insert(UsuarioEntidade usuario){
        Conexao conexao = new Conexao();
        try{
            PreparedStatement sql = conexao.getConexao().prepareStatement("INSERT INTO usuarios (nome, tipo, senha, cpf, email) VALUES(?, ?, ?, ?, ?)");
            
            
            
            sql.setString(1, usuario.getNome());
            sql.setString(2, usuario.getTipo());
            sql.setString(3, usuario.getSenha());
            sql.setString(4, usuario.getCpf());
            sql.setString(5, usuario.getEmail());
            sql.executeUpdate();
            
        }catch (SQLException e) {
            
            throw new RuntimeException("Query (inserir) incorreto " + e.getMessage());
            
        }finally{
            conexao.closeConexao();
        }
    }
    
    @Override
    public void delete(int id) {
        Conexao conexao = new Conexao();
       // UsuarioEntidade usuario = new UsuarioEntidade();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("DELETE FROM usuarios WHERE ID = ? ");
            sql.setInt(1, id);
            sql.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Query de delete (excluir) incorreta "  + e.getMessage());
        } finally {
            conexao.closeConexao();
        }
    }
    
    public void update(UsuarioEntidade usuario)  {
        Conexao conexao = new Conexao();
        
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("UPDATE usuarios SET nome = ?, cpf = ?, tipo = ?, senha = ?, email = ?  WHERE ID = ? ");
            sql.setString(1, usuario.getNome());
            sql.setString(2, usuario.getCpf());
            sql.setString(3, usuario.getTipo());
            sql.setString(4, usuario.getSenha());
            sql.setString(5, usuario.getEmail());
            sql.setInt(6, usuario.getId());
            sql.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Query de update (alterar) incorreta: "  + e.getMessage());
        } finally {
            conexao.closeConexao();
        }
    }
    
 
    public UsuarioEntidade logar(String cpf, String password) {
        Conexao conexao = new Conexao();
        
        try{
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM Usuarios WHERE cpf = ? and senha = ?");
             
            sql.setString(1, cpf);
            sql.setString(2, password);
            ResultSet resultado = sql.executeQuery();
            
            
            if(resultado!=null){
                while(resultado.next()){
                    
                   
                    int id = (resultado.getInt("ID"));
                    String nome = (resultado.getString("NOME"));
                    String tipo = (resultado.getString("TIPO"));
                    //String senha = (resultado.getString("SENHA"));
                    //String cpf = (resultado.getString("CPF"));
                    String email = (resultado.getString("EMAIL"));

                    UsuarioEntidade usuario = new UsuarioEntidade( nome, tipo, cpf, email);
                    usuario.setId(id);
                    
                    return usuario;
                }
            }
            return null;
            
        } catch (SQLException e) {
            throw new RuntimeException("Query (Logar) incorreto "  + e.getMessage());
        } finally{
            conexao.closeConexao();
        }
    }
    
        public UsuarioEntidade getByCpf(String cpf) {
        Conexao conexao = new Conexao();
        
        try{
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM usuarios WHERE cpf = ?");
             
            sql.setString(1, cpf);
            ResultSet resultado = sql.executeQuery();
            
            
            if(resultado!=null){
                while(resultado.next()){
                    
                   
                    int id = (resultado.getInt("ID"));
                    String nome = (resultado.getString("NOME"));
                    String tipo = (resultado.getString("TIPO"));
                    //String senha = (resultado.getString("SENHA"));
                    //String cpf = (resultado.getString("CPF"));
                    String email = (resultado.getString("EMAIL"));
                       
                    UsuarioEntidade usuario = new UsuarioEntidade( nome, tipo, cpf, email);
                    usuario.setId(id);
                    
                    return usuario;
                }
            }
            return null;
            
        } catch (SQLException e) {
            throw new RuntimeException("Query (Logar) incorreto "  + e.getMessage());
        } finally{
            conexao.closeConexao();
        }
    }
    
    
    public ArrayList<UsuarioEntidade> getAll() {
        ArrayList<UsuarioEntidade> meusUsuarios = new ArrayList();
        Conexao conexao = new Conexao();
        
        try {
            String selectSQL = "SELECT * FROM usuarios order by nome";
            PreparedStatement preparedStatement =  conexao.getConexao().prepareStatement(selectSQL);
            ResultSet resultado = preparedStatement.executeQuery();
            
            if (resultado != null) {
                while (resultado.next()) {
                    int id = Integer.parseInt(resultado.getString("id"));
                    String nome = (resultado.getString("NOME"));
                    String tipo = (resultado.getString("TIPO"));
                    //String senha = (resultado.getString("SENHA"));
                    String cpf = (resultado.getString("CPF"));
                    String email = (resultado.getString("EMAIL"));
                    
                    UsuarioEntidade usuario = new UsuarioEntidade( nome, tipo, cpf, email);
                    
                    usuario.setId(id);
                   
                    
                    meusUsuarios.add(usuario);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Query de select (ListaDeUsuarios) incorreta "  + e.getMessage());
        } finally {
            conexao.closeConexao();
        }
        return meusUsuarios;
    }
    

    
    @Override
    public UsuarioEntidade get(int id) {
        Conexao conexao = new Conexao();
        
        try{
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM Usuarios WHERE ID = ?");
            sql.setInt(1, id);
            ResultSet resultado = sql.executeQuery();
            
            
            if(resultado!=null){
                while(resultado.next()){
                    

                    
                    String nome = (resultado.getString("NOME"));
                    String tipo = (resultado.getString("TIPO"));
                    String senha = (resultado.getString("SENHA"));
                    String cpf = (resultado.getString("CPF"));
                    String email = (resultado.getString("EMAIL"));
                    UsuarioEntidade usuario = new UsuarioEntidade( nome, tipo, cpf, email);
                    
                   usuario.setId(id);
                    
                    
                    return usuario;
                }
            }
            return null;
            
        } catch (SQLException e) {
            throw new RuntimeException("Query de select (get usuario) incorreto "  + e.getMessage());
        } finally{
            conexao.closeConexao();
        }
    }
    
}
