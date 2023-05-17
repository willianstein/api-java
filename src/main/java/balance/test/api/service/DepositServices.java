package balance.test.api.service;

import balance.test.api.entity.Account;
import balance.test.api.entity.Deposit;

public class DepositServices extends Deposit {

    private int amount;
    private int id;

    public DepositServices(int id, int amount) {
        this.id = id;
        this.amount = amount;
    }

    public DepositServices() {
      
    }

    // public void imprimirExtrato() {
    //     System.out.println("#### Extrato de Conta Corrente #####");
    //     super.imprimirInfosComuns();
    // }

    public int getAccount(Long id) {
       return super.getAccountId(); 
    }
    
    // public Deposit depositAccount() {
        
    //     Deposit deposit = new Deposit();
              
    //      deposit.deposit(amount);

    //     return deposit;
     
    // }
    
}
