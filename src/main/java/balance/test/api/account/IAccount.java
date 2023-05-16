package balance.test.api.account;

public interface IAccount {
    
    void sacar(double valor);

    void depositar(double valor);

    void transferir(double valor, Account contaDestino);
}
