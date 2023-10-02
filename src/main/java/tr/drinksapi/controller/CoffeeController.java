package tr.drinksapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tr.drinksapi.model.Coffee;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class CoffeeController {

    private final AtomicLong counter = new AtomicLong();

    @GetMapping(value = "/coffeelover")
    public String coffeeLover() {
        return "I like coffee!";
    }

    @GetMapping(value = "/coffee")
    public ResponseEntity<Coffee> getCoffee(@RequestParam(value = "name", defaultValue = "latte") String name) {
        return new ResponseEntity<>(new Coffee(counter.incrementAndGet(), name), HttpStatus.OK);
    }
}
