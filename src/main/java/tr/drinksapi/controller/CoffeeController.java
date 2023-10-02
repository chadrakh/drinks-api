package tr.drinksapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tr.drinksapi.model.Coffee;

@RestController
public class CoffeeController {

    @GetMapping(value = "/coffeelover")
    public String coffeeLover() {
        return "I like coffee!";
    }

    @GetMapping(value = "/coffee")
    public ResponseEntity<Coffee> getCoffee(@RequestParam(required = false) String name) {
        Long id = 1L;
        String coffeeName = "latte";

        if(name != null) {
            coffeeName = name;
        }

        Coffee coffee = Coffee.builder()
                .id(id)
                .name(coffeeName)
                .build();

        return new ResponseEntity<>(coffee, HttpStatus.OK);
    }
}
