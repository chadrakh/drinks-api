package tr.drinksapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoffeeController {

    @GetMapping(value = "/coffee-lover")
    public String coffeeLover() {
        return "I like coffee!";
    }
}
