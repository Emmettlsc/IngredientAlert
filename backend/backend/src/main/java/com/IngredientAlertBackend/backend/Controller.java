package com.IngredientAlertBackend.backend;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/api/{param}")
    public String index(@PathVariable String ingredient) {
        return "Here is your ingredient: " + ingredient;
    }

}

class Ingredient {
    private String name;

    public String getName() {
        return name;
    }
}