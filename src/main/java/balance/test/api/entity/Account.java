package balance.test.api.entity;


public class Account {
 
    private int destination;
    protected int amount;
    private String type;
    private int origin;
    private int id;

    public Account(int id, int amount) {
        this.id = id;
        this.amount = amount;
    }

    public Account() {
    }

    public int getAmount() {
        return amount;
    }
    
    public String getType() {
        return type.toUpperCase();
    } 

    public int getAccountId() {
        return id;
    } 
    
    public int getDestination() {
        return destination;
    } 
    
    public int getBalance() {
        return amount;
    }

   public String toString() {
        return "destination" +": + { " +
                "id: " + id +
                ", balance: " + amount +
                // ", cliente=" + cliente +
                '}';
    }

    public String imprimirInfosComuns() {
        return String.format("Número: %d%n", this.id, "Saldo: %.2f%n", this.amount);
    }


    public void sacar(int valor) {
        amount = amount - valor;

    }

    public void deposit(double valor) {
        if(getAccountId() == 0){
            id = destination;
        }
    //  if(getAccountId()){
    //         id = destination;
    //         System.out.println("asd");
    //     }
    //     System.out.println(id);
    //       amount += valor;

    }

    // public void transferir(int valor, Account contaDestino) {
    //     this.sacar(valor);
    //     contaDestino.deposit(valor, this.getAccountId());

    // }
}
