package storage;

import java.util.ArrayList;
import entidade.ContaEntidade;
import java.util.List;
import java.util.Map;

public class ContaStorage {    
    private final List<ContaEntidade> listaContas;
    
    public ContaStorage(){
        this.listaContas = new ArrayList<>();
    }
    
    public void addConta(ContaEntidade conta){
        listaContas.add(conta);
    }
    
    public int getTamanho(){
        return listaContas.size();
    }
    
    public void deposito(int id, double valor){
        ContaEntidade conta = listaContas.get(id);
        conta.deposito(valor);
    }
    
    public void saque(int id, double valor){
        ContaEntidade conta = listaContas.get(id);
        conta.saque(valor);
    }
    
    public List<ContaEntidade> getContas(int idUsuario){
        List<ContaEntidade> listaContasUsuario = new ArrayList<>();
        
        for (ContaEntidade conta : listaContas) {
            Map<String, Object> dados = conta.getDadosConta();
            if(idUsuario == (int) dados.get("idUsuario")){
                listaContasUsuario.add(conta);
            }
        }
        
        return(listaContasUsuario);
    }
}
