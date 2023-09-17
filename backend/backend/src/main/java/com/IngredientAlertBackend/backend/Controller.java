package com.IngredientAlertBackend.backend;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class Controller {

    @GetMapping("/api/code/{param}")
    public String getCode(@PathVariable String param) {
        String url = "https://world.openfoodfacts.org/api/v2/product/" + param + ".json";
        RestTemplate temp = new RestTemplate();
        String result = temp.getForObject(url,String.class);
        return result;
    }
    @GetMapping("/api/test")
    public String getIngredient() {
        return "hello";
    @GetMapping("/api/{param}")
    public String index(@PathVariable String ingredient) {
        return "Here is your ingredient: " + ingredient;
    }

}

class Ingredient {
    private String name;
    private String[] ingredients;

    private String effect;
    private HashMap<String, String> harmfulIngredients = HashMap<String, String>();

    harmfulIngredients.put("high fructose corn syrup", "Excess amounts can lead to diabetes and obesity.");
    harmfulIngredients.put("canola oil", "Leads to imflammation.");
    harmfulIngredients.put("palm oil", "Leads to imflammation.");
    harmfulIngredients.put("vegetable oil", "Leads to imflammation.");
    harmfulIngredients.put("carrageenan", "Increases fasting blood sugar and glucose intolerance.");
    harmfulIngredients.put("monosodium glutamate", "High in sodium and leads to addiction.");

    public String getName() {
        return name;
    }

    public String[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(String[] ingredients) {
        this.ingredients = ingredients;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

}
