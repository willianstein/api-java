package balance.test.api.entity;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "id", "balance" })
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
        return  "{\"description\": {\"id\":\""+id+"\", \"balance\":" + balance + "}" +"}";


        // return  "id:"+id+", balance:" + balance + '}';
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

