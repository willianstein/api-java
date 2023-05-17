package balance.test.api.service;

import balance.test.api.entity.Account;
import balance.test.api.entity.Deposit;

public class DepositServices extends Deposit {

    public DepositServices() {
        super();
    }

    // public void imprimirExtrato() {
    //     System.out.println("#### Extrato de Conta Corrente #####");
    //     super.imprimirInfosComuns();
    // }

    public int getAccount(Long id) {
       return super.getAccountId(); 
    }
    
    // public Deposit depositAccount(Deposit deposit) {
              
    //      deposit.deposit(amount);

    //     return deposit;
     
    // }
    
}
