package balance.test.api.service;

import balance.test.api.entity.Account;

public class AccountService extends Account{
    
    public AccountService() {
        super();
    }

    public void imprimirExtrato() {
        System.out.println("#### Extrato de Conta Corrente #####");
        super.imprimirInfosComuns();
    }

    public int getAccount(Long id) {
       return super.getAccountId(); 
    }
    
    public Account accountMovement(Account account) {

         if(account.getType() == "deposit"){

         })
        return account;
     
    }
}
