package balance.test.api.controller;

import org.springframework.boot.jackson.JsonObjectSerializer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.annotation.JsonAlias;

import balance.test.api.entity.Account;
import balance.test.api.http.ResponseHandler;
import balance.test.api.service.AccountService;
import ch.qos.logback.classic.encoder.JsonEncoder;
import ch.qos.logback.core.encoder.JsonEncoderBase;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @ResponseBody
    public ResponseEntity Event(@RequestBody Account account) {

        try {
            AccountService ccorrente = new AccountService();  
            var o =   ccorrente.accountMovement(account); 

            System.out.println();
            
            // return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
            //        account.getAccountId().toString(),
            //        account.getBalance()
            // );

            // return ResponseEntity.ok().body(new Account(
            //     account.getAccountId(),
            //     account.getBalance()
            //    ));

            // List<String> message = account.toString();
        //   return  ResponseEntity.body(, HttpStatus.NOT_FOUND);
                    

         return ResponseEntity.status(HttpStatus.CREATED).body(o);




            //  return ResponseHandler.generateResponse(HttpStatus.OK, o);

        } catch (Exception e) {
            return ResponseHandler.generateResponse(HttpStatus.MULTI_STATUS, null);
        }
    }
}