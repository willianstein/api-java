package balance.test.api.controller;

import balance.test.api.commons.enums.Types;

import java.util.Collections;

import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import balance.test.api.entity.Account;
import balance.test.api.http.ResponseHandler;
import balance.test.api.service.BalanceService;

@RestController
@RequestMapping("")
public class BalanceController {

    @Autowired
    BalanceService balanceService;

    @PostMapping("/reset") 
    @ResponseStatus(code = HttpStatus.OK)
    public String Reset() {
        return "OK";
    }

    @GetMapping("/verify-account")
    public ResponseEntity<?> verifyAccount(@RequestParam int account_id) {
        return balanceService.verifyAccount(account_id);
    }

    @PostMapping("/event")
    public ResponseEntity<?> deposit(@RequestBody Account account) {
         return ResponseEntity.status(HttpStatus.CREATED).body(account.toString());
    }
}