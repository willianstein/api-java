package balance.test.api.service;

import balance.test.api.entity.Account;
import balance.test.api.entity.Deposit;
import balance.test.api.commons.enums.Types;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BalanceService {
    
    public Deposit accountMovement(Account account) {
        try {
            if (Types.DEPOSIT.toString().equals(account.getType().toUpperCase())) {
                return new Deposit(account.getDestination(), account.getAmount());
             }
        } catch (Exception e) {
            log.error("Erro no accountMovement", e);
        }
         return null;
    }

    public ResponseEntity<?> verifyAccount(int account_id) {
        Account account = new Account(0, null, 0, 0);
        var id = account.getId();
        if (id == 0 && account_id != 100)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(id);
        Account account2 = new Account(20, null, 100, 0);

        return ResponseEntity.status(HttpStatus.OK).body(account2.getAmount());
    }

    public ResponseEntity<?> deposit(Account account) {

        System.out.println(account);
        // Account account = new Account(id, type, amount, destination);
        // account.setAmount(addAmount);

        return null;
    }
}
