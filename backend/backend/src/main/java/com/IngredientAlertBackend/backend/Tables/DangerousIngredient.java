import jakarta.persistence.*;
@Entity
public class DangerousIngredient {
    @Id
    @ManyToOne
    private Product product;

    @Id
    @ManyToOne
    private Ingredient ingredient;

    private String health_risk;

    // Getters and setters
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public String getHealth_risk() {
        return health_risk;
    }

    public void setHealth_risk(String health_risk) {
        this.health_risk = health_risk;
    }
}
