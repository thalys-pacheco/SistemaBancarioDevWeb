package storage;

import java.util.ArrayList;
import models.ContaModel;
import java.util.List;
import java.util.Map;

public class ContaStorage {    
    private final List<ContaModel> listaContas;
    
    public ContaStorage(){
        this.listaContas = new ArrayList<>();
    }
    
    public void addConta(ContaModel conta){
        listaContas.add(conta);
    }
    
    public int getTamanho(){
        return listaContas.size();
    }
    
    public List<ContaModel> getContas(int idUsuario){
        List<ContaModel> listaContasUsuario = new ArrayList<>();
        
        for (ContaModel conta : listaContas) {
            Map<String, Object> dados = conta.getDadosConta();
            if(idUsuario == (int) dados.get("idUsuario")){
                listaContasUsuario.add(conta);
            }
        }
        
        return(listaContasUsuario);
    }
}
