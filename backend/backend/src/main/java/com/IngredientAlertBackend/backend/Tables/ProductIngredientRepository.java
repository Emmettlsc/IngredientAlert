import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductIngredientRepository extends JpaRepository<ProductIngredient, Long> {
    // Add custom query methods if needed
}