package balance.test.api.http;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
    public static ResponseEntity<Object> generateResponse( HttpStatus status, Object responseObj) {
        Map<String, Object> map = new HashMap<String, Object>();

            map.put("asd", responseObj);

            return new ResponseEntity<Object>(map,status);
    }
}
