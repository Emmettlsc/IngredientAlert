import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductIngredientService {
    private final ProductIngredientRepository productIngredientRepository;

    @Autowired
    public ProductIngredientService(ProductIngredientRepository productIngredientRepository) {
        this.productIngredientRepository = productIngredientRepository;
    }

    // Implement service methods for ProductIngredient-related operations

    public List<ProductIngredient> getAllProductIngredients() {
        return productIngredientRepository.findAll();
    }

    public ProductIngredient addProductIngredient(ProductIngredient productIngredient) {
        return productIngredientRepository.save(productIngredient);
    }

    public void removeProductIngredient(Long productId, Long ingredientId) {
        productIngredientRepository.deleteById(new ProductIngredientKey(productId, ingredientId));
    }
}
