import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DangerousIngredientService {
    private final DangerousIngredientRepository dangerousIngredientRepository;

    @Autowired
    public DangerousIngredientService(DangerousIngredientRepository dangerousIngredientRepository) {
        this.dangerousIngredientRepository = dangerousIngredientRepository;
    }

    // Implement service methods for DangerousIngredient-related operations

    public List<DangerousIngredient> getAllDangerousIngredients() {
        return dangerousIngredientRepository.findAll();
    }

    public DangerousIngredient addDangerousIngredient(DangerousIngredient dangerousIngredient) {
        return dangerousIngredientRepository.save(dangerousIngredient);
    }

    public void removeDangerousIngredient(Long productId, Long ingredientId) {
        dangerousIngredientRepository.deleteById(new DangerousIngredientKey(productId, ingredientId));
    }
}
