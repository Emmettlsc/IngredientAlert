import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {
    private final IngredientService ingredientService;

    @Autowired
    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping("/")
    public List<Ingredient> getAllIngredients() {
        return ingredientService.getAllIngredients();
    }

    @GetMapping("/{id}")
    public Ingredient getIngredientById(@PathVariable Long id) {
        return ingredientService.getIngredientById(id);
    }

    @PostMapping("/")
    public Ingredient addIngredient(@RequestBody Ingredient ingredient) {
        return ingredientService.addIngredient(ingredient);
    }

    @DeleteMapping("/{id}")
    public void removeIngredient(@PathVariable Long id) {
        ingredientService.removeIngredient(id);
    }
}
