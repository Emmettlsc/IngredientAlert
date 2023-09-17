package com.IngredientAlertBackend.backend;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.json.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
//        String url = "https://world.openfoodfacts.org/api/v2/product/" + param + ".json";
//        //image_url
//        RestTemplate temp = new RestTemplate();
//        JsonNode result = temp.getForObject(url, JsonNode.class);
//
//        JsonNode brandName = result.get("product").get("brands");
//        JsonNode productName = result.get("product").get("product_name");
//        JsonNode ingredients = result.get("product").get("ingredients_text");
//        JSONArray arr = new JSONArray();
//        arr.put(brandName);
//        arr.put(productName);
//        arr.put(ingredients);
//
//        return arr;

        String url = "https://world.openfoodfacts.org/api/v2/product/" + param + ".json";
        //image_url
        RestTemplate temp = new RestTemplate();
        JsonNode result = temp.getForObject(url, JsonNode.class);

        JsonNode brandName = result.get("product").get("brands");
        JsonNode productName = result.get("product").get("product_name");
        JsonNode ingredients = result.get("product").get("ingredients_text");

        String[] ingredientsArr = ingredients.textValue().split(", ");


        ObjectMapper mapper = new ObjectMapper();
        List<String> e = new ArrayList<String>();
        ArrayNode array = mapper.valueToTree(e);
        ObjectNode ingredientsNode = mapper.valueToTree(ingredients_text);
        ingredientsNode.putArray("ingredients_text").addAll(array);
        ingredients = mapper.createObjectNode().set("ingredients_text", ingredientsNode);

        ArrayList<String> harmfulIngredientsList = new ArrayList<String>();
        ArrayList<String> risksList = new ArrayList<String>();

        for (int i = 0; i < ingredientsArr.length; i++) {
            if (myMap.containsKey(ingredientsArr[i])) {
                risksListsList.add(myMap.get(ingredientsArr[i]));
                // needs list of harmful ingredients
            }
        }

        // needs to turn the 2 lists into JsonNode objects

        JSONArray arr = new JSONArray();
        arr.put(brandName);
        arr.put(productName);
        arr.put(ingredients);

        JsonNode result = temp.postForObject(url, JSONArray.class);

        return arr;
    }

    @GetMapping("/history")
    public JSONArray getHistory(@PathVariable String param) throws JsonProcessingException {
        String url = "https://world.openfoodfacts.org/api/v2/product/" + param + ".json";
        //image_url
        RestTemplate temp = new RestTemplate();
        JSONArray result = temp.getForObject(url, JSONArray.class);

        return result;
    }

}

