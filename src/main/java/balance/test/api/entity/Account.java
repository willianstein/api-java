package balance.test.api.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    private Integer id;
    private String  type;
    private Integer amount;
    private Integer destination;


     public String toString() {
        return  "{\"description\": {\"id\":\""+destination+"\", \"balance\":" + amount + "}" +"}";
    }
    
}
