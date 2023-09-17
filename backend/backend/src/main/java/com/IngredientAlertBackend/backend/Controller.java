package com.IngredientAlertBackend.backend;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.json.*;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;


@RestController
public class Controller {
    @Bean
    public Map<String, String> myMap() {
        java.util.Map<String, String> harmfulIngredients = new java.util.HashMap<String, String>();

        harmfulIngredients.put("aspartame", "Large amounts of aspartame can cause cancer.");
        harmfulIngredients.put("high fructose corn syrup", "Excess amounts can lead to diabetes and obesity.");
        harmfulIngredients.put("canola oil", "Leads to imflammation.");
        harmfulIngredients.put("palm oil", "Leads to imflammation.");
        harmfulIngredients.put("vegetable oil", "Leads to imflammation.");
        harmfulIngredients.put("carrageenan", "Increases fasting blood sugar and glucose intolerance.");
        harmfulIngredients.put("monosodium glutamate", "High in sodium and leads to addiction.");
        return harmfulIngredients;
    }
    @GetMapping("/api/code/{param}")
    public JSONArray getCode(@PathVariable String param) throws JsonProcessingException {
        String url = "https://world.openfoodfacts.org/api/v2/product/" + param + ".json";
        //image_url
        RestTemplate temp = new RestTemplate();
        JsonNode result = temp.getForObject(url, JsonNode.class);

        JsonNode brandName = result.get("product").get("brands");
        JsonNode productName = result.get("product").get("product_name");
        JsonNode ingredients = result.get("product").get("ingredients_text");
        JSONArray arr = new JSONArray();
        arr.put(brandName);
        arr.put(productName);
        arr.put(ingredients);

        return arr;
    }

    @GetMapping("/api/test")
    public String getIngredient() {
        return "hello";
    @GetMapping("/api/{param}")
    public String index(@PathVariable String ingredient) {
        return "Here is your ingredient: " + ingredient;
    }

}
