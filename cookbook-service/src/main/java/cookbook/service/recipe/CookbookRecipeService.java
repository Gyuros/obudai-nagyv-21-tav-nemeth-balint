package cookbook.service.recipe;

import cookbook.domain.Recipe;
import cookbook.exception.ModelNotFoundException;
import cookbook.service.CookbookBaseService;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class CookbookRecipeService extends CookbookBaseService<Recipe> implements RecipeService {

    public CookbookRecipeService() { super("recipes.txt"); }

    @Override
    public void addRecipe(Recipe recipe) {
        models.add(recipe);
    }

    @Override
    public List<Recipe> getRecipes() {
        return Collections.unmodifiableList(models);
    }

    @Override
    public void deleteRecipe(String name) throws ModelNotFoundException {
        Recipe removable = models.stream()
                .filter(r -> r.getName().equals(name))
                .findFirst()
                .orElse(null);

        if(removable == null)
            throw new ModelNotFoundException("Model not found.");

        models.remove(removable);
    }
}
