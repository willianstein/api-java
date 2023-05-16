package balance.test.api.account;

public abstract class Account implements IAccount {
 
    protected int agencia;
    protected int numero;
    protected double saldo;

    public Account() {
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }


    @Override
    public String toString() {
        return "Conta{" +
                "agencia=" + agencia +
                ", numero=" + numero +
                ", saldo=" + saldo +
                // ", cliente=" + cliente +
                '}';
    }

    protected void imprimirInfosComuns() {
        System.out.printf(String.format("Agência: %d%n", this.agencia));
        System.out.printf(String.format("Número: %d%n", this.numero));
        System.out.printf(String.format("Saldo: %.2f%n", this.saldo));
    }

    @Override
    public void sacar(double valor) {
        saldo = saldo - valor;

    }

    @Override
    public void depositar(double valor) {
        saldo = saldo + valor;

    }

    @Override
    public void transferir(double valor, Account contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);

    }
}
