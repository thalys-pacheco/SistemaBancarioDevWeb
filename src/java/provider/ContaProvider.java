package provider;

import java.util.List;
import models.ContaModel;
import storage.ContaStorage;

public class ContaProvider {

    static public ContaStorage contaStorage = new ContaStorage();
    
    static public void addConta(ContaModel conta){
        contaStorage.addConta(conta);
    }
    
    static public int getTamanho(){
        return contaStorage.getTamanho();
    }
    
    static public List<ContaModel> getContas(int id){
        return contaStorage.getContas(id);
    }
}