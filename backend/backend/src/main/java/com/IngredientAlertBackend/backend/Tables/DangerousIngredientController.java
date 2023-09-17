import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/dangerous-ingredients")
public class DangerousIngredientController {
    private final DangerousIngredientService dangerousIngredientService;

    @Autowired
    public DangerousIngredientController(DangerousIngredientService dangerousIngredientService) {
        this.dangerousIngredientService = dangerousIngredientService;
    }

    @GetMapping("/")
    public List<DangerousIngredient> getAllDangerousIngredients() {
        return dangerousIngredientService.getAllDangerousIngredients();
    }

    @PostMapping("/")
    public DangerousIngredient addDangerousIngredient(@RequestBody DangerousIngredient dangerousIngredient) {
        return dangerousIngredientService.addDangerousIngredient(dangerousIngredient);
    }

    @DeleteMapping("/{productId}/{ingredientId}")
    public void removeDangerousIngredient(@PathVariable Long productId, @PathVariable Long ingredientId) {
        dangerousIngredientService.removeDangerousIngredient(productId, ingredientId);
    }
}
