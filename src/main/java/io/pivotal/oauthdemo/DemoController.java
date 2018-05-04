package io.pivotal.oauthdemo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.*;

import static org.springframework.http.HttpStatus.*;

@RestController
public class DemoController {
    private Map<String, Demo> demoMap = new HashMap<>();

    @GetMapping("/demos")
    @ResponseBody
    public Collection<Demo> list() {
        return demoMap.values();
    }

    @PostMapping("/demos")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody Demo body) {
        String id = UUID.randomUUID().toString();
        body.setDemoId(id);
        body.setCreated(new Date());
        demoMap.put(id, body);
        return new ResponseEntity<>(body, CREATED);
    }

    @DeleteMapping(value = "/{demoId}")
    public ResponseEntity<?> delete(@PathVariable String demoId) {
        if (demoId == null || demoMap.get(demoId) == null) {
            throw new HttpClientErrorException(NOT_FOUND, "Entry with id(" + demoId + ") not found.");
        }
        demoMap.remove(demoId);
        return new ResponseEntity<>(OK);
    }

    @ExceptionHandler
    public ResponseEntity<?> handleError(HttpClientErrorException exception) {
        Map<String, String> response = Collections.singletonMap("message", exception.getMessage());
        return new ResponseEntity<>(response, exception.getStatusCode());
    }
}
