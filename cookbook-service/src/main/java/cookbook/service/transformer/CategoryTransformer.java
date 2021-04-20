package cookbook.service.transformer;

import cookbook.domain.Category;
import cookbook.persistence.entity.Recipe;
import cookbook.persistence.entity.RecipeCategory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryTransformer {

    public List<RecipeCategory> toRecipeCategories(List<Category> categories, Recipe recipe) {
        return categories.stream().map(c -> new RecipeCategory(recipe, c)).collect(Collectors.toList());
    }

    public List<Category> toCategories(List<RecipeCategory> categories) {
        return categories.stream().map(c -> c.getCategory()).collect(Collectors.toList());
    }
}
