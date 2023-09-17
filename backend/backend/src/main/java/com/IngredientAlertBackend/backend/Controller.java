package com.IngredientAlertBackend.backend;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@RestController
public class Controller {

    @GetMapping("/api/code/{param}")
    public Ingredient getCode(@PathVariable String param) throws JsonProcessingException {
        String url = "https://world.openfoodfacts.org/api/v2/product/" + param + ".json";
        //image_url
        RestTemplate temp = new RestTemplate();
        String result = temp.getForObject(url, String.class);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(result);

        Ingredient newIngredient = new Ingredient();
        JsonNode noode = jsonNode.get("id");
        System.out.println(noode != null);
        //newIngredient.setBrandName(jsonNode.get("id").textValue());
        //newIngredient.setName(jsonNode.get("product_name").asText());
        //newIngredient.setIngredients(new String[]{jsonNode.get("ingredients").asText()});
        newIngredient.setEffect("big ass dick");

        return newIngredient;
    }

    @GetMapping("/api/test")
    public String getIngredient() {
        return "hello";
    }

}

class Ingredient {
    private String brandName;
    private String name;
    private String[] ingredients;

    private String effect;

    private HashMap<String, String> harmfulIngredients = HashMap<String, String>();

    harmfulIngredients.put("aspartame", "Large amounts of aspartame can cause cancer.");
    harmfulIngredients.put("high fructose corn syrup", "Excess amounts can lead to diabetes and obesity.");
    harmfulIngredients.put("canola oil", "Leads to imflammation.");
    harmfulIngredients.put("palm oil", "Leads to imflammation.");
    harmfulIngredients.put("vegetable oil", "Leads to imflammation.");
    harmfulIngredients.put("carrageenan", "Increases fasting blood sugar and glucose intolerance.");
    harmfulIngredients.put("monosodium glutamate", "High in sodium and leads to addiction.");
    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public void setName(String name) {
        this.name = name;
    }

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
