/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entidade.ContaEntidade;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Rodrigo
 */
public class ContaDAO implements DAO<ContaEntidade>{
    
    //inserindo conta
    public void  insert(ContaEntidade conta){
        Conexao conexao = new Conexao();
        try{
            PreparedStatement sql = conexao.getConexao().prepareStatement("INSERT INTO contas (idUsuario, tipo, saldo) VALUES(?, ?, ?)");
            
            
            
            sql.setInt(1, conta.getIdUsuario());
            sql.setString(2, conta.getTipo());
            sql.setDouble(3, conta.getSaldo());
            sql.executeUpdate();
            
        }catch (SQLException e) {
            
            throw new RuntimeException("Query (inserir) incorreto: " + e.getMessage());
            
        }finally{
            conexao.closeConexao();
        }
    }
    
    @Override
    public void delete(int id) {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("DELETE FROM contas WHERE ID = ? ");
            sql.setInt(1, id);
            sql.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Query de delete (excluir) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }
    
    public void update(ContaEntidade conta)  {
        Conexao conexao = new Conexao();
        
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("UPDATE contas SET idUsuario = ?, tipo = ?, saldo = ?  WHERE ID = ? ");
            sql.setInt(1, conta.getIdUsuario());
            sql.setString(2, conta.getTipo());
            sql.setDouble(3, conta.getSaldo());
            sql.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Query de update (alterar) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }
    
 
    
    
    
    public ArrayList<ContaEntidade> getAll() {
        ArrayList<ContaEntidade> minhasContas = new ArrayList();
        Conexao conexao = new Conexao();
        
        try {
            String selectSQL = "SELECT * FROM contas order by nome";
            PreparedStatement preparedStatement =  conexao.getConexao().prepareStatement(selectSQL);
            ResultSet resultado = preparedStatement.executeQuery();
            
            if (resultado != null) {
                while (resultado.next()) {
                    
                    int id = (resultado.getInt("ID"));
                    
                    int idUsuario = (resultado.getInt("IDUSUARIO"));
                    String tipo = (resultado.getString("TIPO"));
                    double saldo = (resultado.getDouble("SALDO"));
                  
                    
                    ContaEntidade conta = new ContaEntidade(idUsuario, tipo, saldo);
                    conta.setId(id);
                   
                    
                    minhasContas.add(conta);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Query de select (ListaDeUsuarios) incorreta");
        } finally {
            conexao.closeConexao();
        }
        return minhasContas;
    }
    
        public ArrayList<ContaEntidade> getContasByUser(int idUsuario) {
        ArrayList<ContaEntidade> minhasContas = new ArrayList();
        Conexao conexao = new Conexao();
        
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM contas where = idUsuario ? Order By id");
            sql.setInt(1, idUsuario);
            ResultSet resultado = sql.executeQuery();
            
            if (resultado != null) {
                while (resultado.next()) {
                    
                    int id = (resultado.getInt("ID"));
                    String tipo = (resultado.getString("TIPO"));
                    double saldo = (resultado.getDouble("SALDO"));
                  
                    
                    ContaEntidade conta = new ContaEntidade(idUsuario, tipo, saldo);
                    conta.setId(id);
                   
                    
                    minhasContas.add(conta);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Query de select (ListaDeUsuarios) incorreta");
        } finally {
            conexao.closeConexao();
        }
        return minhasContas;
    }
    

    
    @Override
    public ContaEntidade get(int id) {
        Conexao conexao = new Conexao();
        
        try{
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM contas WHERE ID = ?");
            sql.setInt(1, id);
            ResultSet resultado = sql.executeQuery();
            
            
            if(resultado!=null){
                while(resultado.next()){
                    

                    
                    int idUsuario = (resultado.getInt("IDUSUARIO"));
                    String tipo = (resultado.getString("TIPO"));
                    double saldo = (resultado.getDouble("SALDO"));
                  
                    
                    ContaEntidade conta = new ContaEntidade(idUsuario, tipo, saldo);
                    conta.setId(id);
                   
                    
                    
                    return conta;
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
