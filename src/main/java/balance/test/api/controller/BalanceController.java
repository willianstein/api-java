package balance.test.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("")
public class BalanceController {

    @PostMapping("/reset")
    @ResponseStatus(code = HttpStatus.OK)
    public String Reset() {
        return  "OK";
    }

    @GetMapping("/")
    public String buscarPorId(@PathVariable Integer id) {
        var clienteOptional = id;
        if (clienteOptional == 1234) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return "de";
    }
    
    @GetMapping("/balance")
    public ResponseEntity Account(@RequestParam Long account_id) {
        var clienteOptional = account_id;
        var encontra  = 0;

        if (clienteOptional == 1234) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(encontra);
            // throw new ResponseStatusException(
            //     HttpStatus.NOT_FOUND, "entity not found"
            //     );
            // throw new ResponseStatusException(HttpStatus.NOT_FOUND , "0");
        }
        return ResponseEntity.ok().build();
    }

    // @DeleteMapping("/{id}")
    // @Transactional
    // public Long excluir(@PathVariable Long id) {
    //     return id;

    // }

}