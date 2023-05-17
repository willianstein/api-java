package balance.test.api.entity;


public class Account {
 
    protected int destination;
    protected int amount;
    protected String type;
    protected int origin;
    protected int id;

    public Account() {
    }

    public int getAmount() {
        return amount;
    }
    
    public String getType() {
        return type;
    }

    public int getAccountId() {
        return id;
    } 
    
    public int getDestination() {
        return destination;
    }

    public String toString() {
        return "Conta{" +
                ", numero=" + id +
                ", saldo=" + amount +
                // ", cliente=" + cliente +
                '}';
    }

    protected void imprimirInfosComuns() {
        System.out.printf(String.format("Número: %d%n", this.id));
        System.out.printf(String.format("Saldo: %.2f%n", this.amount));
    }


    public void sacar(int valor) {
        amount = amount - valor;

    }

    public void depositar(int valor) {
        amount = amount + valor;

    }

    public void transferir(int valor, Account contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);

    }
}
