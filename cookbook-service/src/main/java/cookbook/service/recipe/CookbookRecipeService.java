package cookbook.service.recipe;

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
        long lastId = models.stream()
                .map(Recipe::getId)
                .max(Long::compare)
                .orElse(1L);

        recipe.setId(lastId + 1);
        models.add(recipe);
    }

    @Override
    public List<Recipe> getRecipes() {
        return Collections.unmodifiableList(models);
    }

    @Override
    public void deleteRecipe(String id) throws ModelNotFoundException {
        Recipe removable = models.stream()
                .filter(r -> r.getId() == Long.parseLong(id))
                .findFirst()
                .orElse(null);

        if(removable == null)
            throw new ModelNotFoundException("Model not found.");

        removable.getUploader().getOwnRecipes().remove(removable);

        models.remove(removable);
    }
}
