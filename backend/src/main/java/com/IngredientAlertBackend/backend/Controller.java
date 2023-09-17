package com.IngredientAlertBackend.backend;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.json.*;

import java.lang.reflect.Array;
import java.util.*;

@RestController
public class Controller {

    private Map<String, String> harmfulIngredients;

    public Map<String, String> harmfulIngredients() {
        Map<String, String> harmfulIngredients = new HashMap<>();
        harmfulIngredients.put("aspartame", "Potential carcinogen, can lead to neurological issues.");
        harmfulIngredients.put("high fructose corn syrup", "Excess amounts can lead to diabetes and obesity.");
        harmfulIngredients.put("canola oil", "Leads to inflammation.");
        harmfulIngredients.put("palm oil", "Leads to inflammation.");
        harmfulIngredients.put("vegetable oil", "Leads to inflammation.");
        harmfulIngredients.put("carrageenan", "Increases fasting blood sugar and glucose intolerance.");
        harmfulIngredients.put("monosodium glutamate", "High in sodium and leads to addiction.");
        return harmfulIngredients;
    }

    @GetMapping("/api/code/{param}")
    public ResponseEntity<Product> getCode(@PathVariable String param) {

        RestTemplate temp = new RestTemplate();
        String url = "https://world.openfoodfacts.org/api/v2/product/" + param + ".json";
        JsonNode result = temp.getForObject(url, JsonNode.class);

        String barcode = result.get("code").asText();
        String brandName = result.get("product").get("brands").asText();
        String productName = result.get("product").get("product_name").asText();
        String image_url = result.get("product").get("image_url").asText();

        // Split ingredients_text by commas to get a list of ingredients
//        List<String> ingredientsList = Arrays.asList(result.get("product").get("ingredients_text").asText().split(", "));

        JsonNode ingredientsNode = result.get("product").get("ingredients_text");
        List<String> ingredients = Arrays.asList(ingredientsNode.asText().split(","));
        Map<String, String> harmfulIngredients = harmfulIngredients();
        List<String> dangerousIngredients = new ArrayList<>();
        Map<String, String> healthRisks = new HashMap<>();


        for (String ingredient : ingredients) {
            if (harmfulIngredients.containsKey(ingredient.toLowerCase().trim())) {
                dangerousIngredients.add(ingredient);
                healthRisks.put(ingredient, harmfulIngredients.get(ingredient.toLowerCase().trim()));
            }
        }

        Product product = new Product();
        product.setName(productName);
        product.setBrand(brandName);
        product.setCode(barcode);
        product.setIngredients(ingredients);
        product.setImage_url(image_url);
        product.setDangerousIngredients(dangerousIngredients);
        product.setHealthRisks(healthRisks);

        return new ResponseEntity<>(product, HttpStatus.OK);
    }

}
