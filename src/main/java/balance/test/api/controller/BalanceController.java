package balance.test.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import balance.test.api.entity.Account;
import balance.test.api.service.AccountService;

@RestController
@RequestMapping("")
public class BalanceController {

    @PostMapping("/reset")
    @ResponseStatus(code = HttpStatus.OK)
    public String Reset() {
        return  "OK";
    }

    @GetMapping("/balance")
    public ResponseEntity Account(@RequestParam Long account_id) {

        AccountService account = new AccountService();  

        var id = account.getAccount(account_id);  

        if (id == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(account);
        }
        return ResponseEntity.ok().build();
    }

    @PostMapping("/event")
    public ResponseEntity Event(@RequestBody Account account) {

        AccountService ccorrente = new AccountService();  

        ccorrente.accountMovement(account); 

         System.out.println(ccorrente);
        
        // return ResponseEntity.status(HttpStatus.OK).body(account);
         return ResponseEntity.ok().build();
    }

}