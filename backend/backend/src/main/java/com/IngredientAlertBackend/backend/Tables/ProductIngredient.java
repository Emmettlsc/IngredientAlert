import javax.persistence.*;
import jakarta.persistence.*;
@Entity
public class ProductIngredient {
    @Id
    @ManyToOne
    private Product product;

    @Id
    @ManyToOne
    private Ingredient ingredient;

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
}
