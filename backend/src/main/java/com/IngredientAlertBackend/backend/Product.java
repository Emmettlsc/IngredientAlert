package com.IngredientAlertBackend.backend;

import java.util.List;
import java.util.Map;

public class Product {
    private String name;
    private String brand;
    private String code;
    private List<String> ingredients;
    private String image_url;
    private List<String> dangerousIngredients;
    private Map<String, String> healthRisks;


    // Default Constructor
    public Product() {}

    // Parametrized Constructor
    public Product(String name, String brand, String code, List<String> ingredients, String image_url) {
        this.name = name;
        this.brand = brand;
        this.code = code;
        this.ingredients = ingredients;
        this.image_url = image_url;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public String getCode() {
        return code;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public String getImage_url() {
        return image_url;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public List<String> getDangerousIngredients() {
        return dangerousIngredients;
    }

    public void setDangerousIngredients(List<String> dangerousIngredients) {
        this.dangerousIngredients = dangerousIngredients;
    }

    public Map<String, String> getHealthRisks() {
        return healthRisks;
    }

    public void setHealthRisks(Map<String, String> healthRisks) {
        this.healthRisks = healthRisks;
    }

    // toString method for debugging purposes
    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", code='" + code + '\'' +
                ", ingredients=" + ingredients +
                ", image_url='" + image_url + '\'' +
                '}';
    }
}
