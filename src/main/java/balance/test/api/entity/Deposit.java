package balance.test.api.entity;

public class Deposit {

    private int balance;
    private int id;

    public Deposit(int id, int balance) {
        this.id = id;
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    } 
    public int getId() {
        return id;
    } 
    
    
   public String toString() {
        return "destination" +": + { " +
                "id: " + id +
                ", balance: " + balance +
                // ", cliente=" + cliente +
                '}';
    }

    // public void deposit(int valor) {
    //     if(getAccountId() == 0){
    //         id = valor;
    //     }
    //  if(getAccountId()){
    //         id = destination;
    //         System.out.println("asd");
    //     }
    //     System.out.println(id);
    //       amount += valor;

    // }

}

