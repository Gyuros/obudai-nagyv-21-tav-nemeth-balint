package cookbook.service.recipe;

import cookbook.domain.Recipe;
import cookbook.persistence.Data;
import cookbook.util.RecipeDataParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class CookbookRecipeService implements RecipeService {

    private static final String INIT_FILE = "recipes.txt";
    private List<Recipe> recipes;

    @Autowired
    private Data data;

    @Autowired
    private RecipeDataParser recipeDataParser;

    @Override
    public void init() throws IOException {
        String initData = data.read(INIT_FILE);
        recipes = recipeDataParser.parse(initData);
    }

    @Override
    public void addRecipe(Recipe recipe) {

    }

    @Override
    public List<Recipe> getRecipes() {
        return null;
    }

    @Override
    public void deleteRecipe(String name) {

    }

    @Override
    public Recipe findById(long id) {
        return recipes.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
