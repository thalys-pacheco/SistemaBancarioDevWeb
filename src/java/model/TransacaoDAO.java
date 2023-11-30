/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entidade.TransacaoEntidade;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class TransacaoDAO implements DAO<TransacaoEntidade>{
     
    @Override
    public void  insert(TransacaoEntidade transacoes){
        Conexao conexao = new Conexao();
        try{
            PreparedStatement sql = conexao.getConexao().prepareStatement("INSERT INTO transacoes (idEmissor, idDestinatario, valor, dataTransacao) VALUES(?, ?, ?, NOW())");
            
            sql.setInt(1, transacoes.getIdEmissor());
            sql.setInt(2, transacoes.getIdDestinatario());
            sql.setDouble(3, transacoes.getValor());
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
            PreparedStatement sql = conexao.getConexao().prepareStatement("DELETE FROM transacoes WHERE ID = ? ");
            sql.setInt(1, id);
            sql.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Query de delete (excluir) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }
    
    @Override
    public void update(TransacaoEntidade transacoes)  {
        Conexao conexao = new Conexao();
        
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("UPDATE contas SET idEmissor = ?, idDestinatario = ?, valor = ?  WHERE ID = ? ");
            sql.setInt(1, transacoes.getIdEmissor());
            sql.setInt(2, transacoes.getIdDestinatario());
            sql.setDouble(3, transacoes.getValor());
            sql.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Query de update (alterar) incorreta "  + e.getMessage());
        } finally {
            conexao.closeConexao();
        }
    }
    
    @Override
    public ArrayList<TransacaoEntidade> getAll() {
        ArrayList<TransacaoEntidade> minhasTransacoes = new ArrayList();
        Conexao conexao = new Conexao();
        
        try {
            String selectSQL = "SELECT * FROM transacoes order by id";
            PreparedStatement preparedStatement =  conexao.getConexao().prepareStatement(selectSQL);
            ResultSet resultado = preparedStatement.executeQuery();
            
            if (resultado != null) {
                while (resultado.next()) {
                    
                    int id = (resultado.getInt("ID"));
                    int idEmissor = (resultado.getInt("IDEMISSOR"));
                    int idDestinatario = (resultado.getInt("IDDESTINATARIO"));
                    double valor = (resultado.getDouble("VALOR"));
                    Date dataTransacao = (resultado.getDate("DATATRANSACAO"));
                    
                    TransacaoEntidade transacoes = new TransacaoEntidade(idEmissor, idDestinatario, valor);
                    transacoes.setId(id);
                    transacoes.setDataTransacao(dataTransacao);
                   
                    minhasTransacoes.add(transacoes);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Query de select (ListaDeUsuarios) incorreta "  + e.getMessage());
        } finally {
            conexao.closeConexao();
        }
        return minhasTransacoes;
    }
    
    public ArrayList<TransacaoEntidade> getTransacoesByConta(int idConta) {
        ArrayList<TransacaoEntidade> minhasTransacoes = new ArrayList();
        Conexao conexao = new Conexao();
        
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM transacoes where idEmissor = ? || idDestinatario = ? Order By id");
            sql.setInt(1, idConta);
            sql.setInt(2, idConta);
            ResultSet resultado = sql.executeQuery();
            
            if (resultado != null) {
                while (resultado.next()) {
                    
                    int id = (resultado.getInt("ID"));
                    int idEmissor = (resultado.getInt("IDEMISSOR"));
                    int idDestinatario = (resultado.getInt("IDDESTINATARIO"));
                    double valor = (resultado.getDouble("VALOR"));
                    Date dataTransacao = (resultado.getDate("DATATRANSACAO"));
                    
                    TransacaoEntidade transacoes = new TransacaoEntidade(idEmissor, idDestinatario, valor);
                    transacoes.setId(id);
                    transacoes.setDataTransacao(dataTransacao);
                   
                    minhasTransacoes.add(transacoes);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Query de select (ListaDeUsuarios) incorreta "  + e.getMessage());
        } finally {
            conexao.closeConexao();
        }
        return minhasTransacoes;
    }
    
    @Override
    public TransacaoEntidade get(int id) {
        Conexao conexao = new Conexao();
        
        try{
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM transacoes WHERE ID = ?");
            sql.setInt(1, id);
            ResultSet resultado = sql.executeQuery();
            
            
            if(resultado!=null){
                while(resultado.next()){
                    
                    int idEmissor = (resultado.getInt("IDEMISSOR"));
                    int idDestinatario = (resultado.getInt("IDDESTINATARIO"));
                    double valor = (resultado.getDouble("VALOR"));
                    Date dataTransacao = (resultado.getDate("DATATRANSACAO"));
                  
                    TransacaoEntidade transacoes = new TransacaoEntidade(idEmissor, idDestinatario, valor);
                    transacoes.setId(id);
                    transacoes.setDataTransacao(dataTransacao);
                   
                    return transacoes;
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
