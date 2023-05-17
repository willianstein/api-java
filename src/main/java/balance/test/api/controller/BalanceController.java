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
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

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
    public ResponseEntity Account(@RequestParam int account_id) {

        AccountService account = new AccountService();  

        var id = account.getAccount(account_id);  

        if (id == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(id);
        }
        return ResponseEntity.ok().build();
    }

    @PostMapping("/event")
    public ResponseEntity Event(@RequestBody Account account) {

        try {
            AccountService ccorrente = new AccountService();  
             var res =   ccorrente.accountMovement(account); 

             System.out.println(res.toString());
             
                // public Map<String, String> getProperties() {
                //     return properties;
                // }
                return ResponseEntity.status(HttpStatus.CREATED).body(""+res);

            //  return ResponseHandler.generateResponseDeposit(HttpStatus.CREATED, res);

        } catch (Exception e) {
            return ResponseHandler.generateResponseDeposit(HttpStatus.MULTI_STATUS, null);
        }
    }
}