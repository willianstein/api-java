package balance.test.api.service;

import balance.test.api.entity.Account;
import balance.test.api.entity.Types;

public class AccountService extends Account{
    
    private Types types;

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

         if(types.DEPOSIT.toString().equals(account.getType())){
             System.out.println("aszxd");
         }
        return account;
     
    }
}
