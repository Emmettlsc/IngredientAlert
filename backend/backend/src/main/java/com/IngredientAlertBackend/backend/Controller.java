package com.IngredientAlertBackend.backend;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/api/{param}")
    public String getIngredient(@PathVariable String ingredient) {
        OpenFoodFactsWrapper wrapper = new OpenFoodFactsWrapperImpl();
        ProductResponse productResponse = wrapper.fetchProductByCode("737628064502");
        return "Here is your ingredient: " + ingredient;
    }

}

class Ingredient {
    private String name;
    private String[] ingredients;

    private String effect;

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
