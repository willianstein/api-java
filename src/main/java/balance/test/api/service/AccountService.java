package balance.test.api.service;

import balance.test.api.entity.Account;
import balance.test.api.entity.Deposit;
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
    
    public Deposit accountMovement(Account account) {

        System.out.println(account.getDestination());
        System.out.println(account.getAmount());

        try {
            if(types.DEPOSIT.toString().equals(account.getType())){
                Deposit account2 = new Deposit(account.getDestination(), account.getAmount());
                System.out.println(account2);
                return account2;
             }
        } catch (Exception e) {
            System.out.println("error");
        }

        return null;
    }
}
