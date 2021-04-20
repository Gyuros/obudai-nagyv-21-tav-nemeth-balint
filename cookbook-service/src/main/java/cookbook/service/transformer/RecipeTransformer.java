package cookbook.service.transformer;

import cookbook.persistence.entity.Recipe;
import cookbook.persistence.repository.CookRepository;
import cookbook.service.dto.RecipeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RecipeTransformer {

    @Autowired
    private CookRepository cookRepository;

    @Autowired
    private IngredientTransformer ingredientTransformer;

    @Autowired
    private CategoryTransformer categoryTransformer;

    @Autowired
    private CookTransformer cookTransformer;

    public Recipe transform(RecipeDto recipeDto) {
        var uploader = cookTransformer.transform(recipeDto.getUploader());
        var categories = categoryTransformer.transform(recipeDto.getCategories());
        var ingredients = ingredientTransformer.transform(recipeDto.getIngredients());

        return new Recipe(
                recipeDto.getName(),
                recipeDto.getServings(),
                recipeDto.getPreparation(),
                uploader,
                categories,
                ingredients);
    }

    public List<RecipeDto> transform(List<Recipe> recipes) {
        return recipes.stream().map(r -> new RecipeDto(
                r.getId(),
                r.getName(),
                r.getServings(),
                r.getPreparation(),
                cookTransformer.transform(r.getUploader()),
                categoryTransformer.transform(r.getCategories()),
                ingredientTransformer.transform(r.getIngredients())))
        .collect(Collectors.toList());
    }
}
