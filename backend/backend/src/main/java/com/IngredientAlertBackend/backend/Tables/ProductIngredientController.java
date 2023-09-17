import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/product-ingredients")
public class ProductIngredientController {
    private final ProductIngredientService productIngredientService;

    @Autowired
    public ProductIngredientController(ProductIngredientService productIngredientService) {
        this.productIngredientService = productIngredientService;
    }

    @GetMapping("/")
    public List<ProductIngredient> getAllProductIngredients() {
        return productIngredientService.getAllProductIngredients();
    }

    @PostMapping("/")
    public ProductIngredient addProductIngredient(@RequestBody ProductIngredient productIngredient) {
        return productIngredientService.addProductIngredient(productIngredient);
    }

    @DeleteMapping("/{productId}/{ingredientId}")
    public void removeProductIngredient(@PathVariable Long productId, @PathVariable Long ingredientId) {
        productIngredientService.removeProductIngredient(productId, ingredientId);
    }
}
