package balance.test.api.account;

public class AccountRepository extends Account{
 
    public AccountRepository() {
        super();
    }

    public void imprimirExtrato() {
        System.out.println("#### Extrato de Conta Corrente #####");
        super.imprimirInfosComuns();
    }

    public int getAccount(Long id) {
       return super.getNumero(); 
    }
}
