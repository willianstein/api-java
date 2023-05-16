package balance.test.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import balance.test.api.account.AccountRepository;
import balance.test.api.account.Account;

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

        AccountRepository ccorrente = new AccountRepository();  

        var account = ccorrente.getAccount(account_id);  

        if (account == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(account);
        }
        return ResponseEntity.ok().build();
    }

    @PostMapping("/event")
    public ResponseEntity Event(@RequestBody Account dados) {

        System.out.println(dados);
        // AccountRepository ccorrente = new AccountRepository();  

        // var account = ccorrente.getAccount(account_id);  

        // if (account == 0) {
        //     return ResponseEntity.status(HttpStatus.NOT_FOUND).body(account);
        // }
        // return ResponseEntity.ok().build();
    }

}