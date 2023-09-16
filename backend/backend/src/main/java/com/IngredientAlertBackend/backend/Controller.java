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
    private HashMap<String, String> harmfulIngredients = HashMap<String, String>();

    harmfulIngredients.put("carcinogen", "Large amounts of carinogen can cause cancer.");
    harmfulIngredients.put("high fructose corn syrup", "Excess amounts can lead to diabetes and obesity.");
    harmfulIngredients.put("canola oil", "Leads to imflammation.");
    harmfulIngredients.put("palm oil", "Leads to imflammation.");
    harmfulIngredients.put("vegetable oil", "Leads to imflammation.");
    harmfulIngredients.put("carrageenan", "Increases fasting blood sugar and glucose intolerance.");
    harmfulIngredients.put("monosodium glutamate", "High in sodium and leads to addiction.");

    public String getName() {
        return name;
    }
}
