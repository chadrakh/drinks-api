package tr.drinksapi.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@AutoConfigureMockMvc
@SpringBootTest
class CoffeeControllerTests {

    @Autowired
    MockMvc mockMvcController;

    @Test
    public void getCoffeeLover() throws Exception {
        String expected = "I like coffee!";

        mockMvcController.perform(
                MockMvcRequestBuilders.get("/coffeelover"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expected));
    }

    @Test void getCoffeeWithNameParamReturnsRequested() throws Exception {
        String requestedCoffee = "mocha";

        mockMvcController.perform(
                MockMvcRequestBuilders.get("/coffee?name=mocha"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(requestedCoffee));
    }

    @Test void getCoffeeWithoutNameParamReturnsDefault() throws Exception {
        String defaultCoffee = "latte";

        mockMvcController.perform(
                        MockMvcRequestBuilders.get("/coffee"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(defaultCoffee));
    }

}