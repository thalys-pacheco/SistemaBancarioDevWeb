package provider;

import java.util.List;
import entidade.ContaEntidade;
import storage.ContaStorage;

public class ContaProvider {

    static public ContaStorage contaStorage = new ContaStorage();
    
    static public void addConta(ContaEntidade conta){
        contaStorage.addConta(conta);
    }
    
    static public int getTamanho(){
        return contaStorage.getTamanho();
    }
    
    static public List<ContaEntidade> getContas(int id){
        return contaStorage.getContas(id);
    }
    
    static public void deposito(int id, double valor){
        contaStorage.deposito(id, valor);
    }
    
    static public void saque(int id, double valor){
        contaStorage.saque(id, valor);
    }
    
}