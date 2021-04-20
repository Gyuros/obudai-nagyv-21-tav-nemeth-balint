package cookbook.service.transformer;

import cookbook.persistence.entity.Recipe;
import cookbook.service.dto.RecipeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RecipeTransformer {

    @Autowired
    private IngredientTransformer ingredientTransformer;

    @Autowired
    private CategoryTransformer categoryTransformer;

    @Autowired
    private CookTransformer cookTransformer;

    @Autowired
    private CommentTransformer commentTransformer;

    public Recipe toRecipe(RecipeDto recipeDto) {
        var uploader = cookTransformer.toCook(recipeDto.getUploader());
        var categories = categoryTransformer.toRecipeCategories(recipeDto.getCategories());
        var ingredients = ingredientTransformer.toIngredients(recipeDto.getIngredients());

        return new Recipe(
                recipeDto.getName(),
                recipeDto.getServings(),
                recipeDto.getPreparation(),
                uploader,
                categories,
                ingredients);
    }

    public List<RecipeDto> toRecipeDtos(List<Recipe> recipes) {
        return recipes.stream().map(r -> new RecipeDto(
                r.getId(),
                r.getName(),
                r.getServings(),
                r.getPreparation(),
                cookTransformer.toCookDto(r.getUploader()),
                categoryTransformer.toCategories(r.getCategories()),
                ingredientTransformer.toIngredientDtos(r.getIngredients()),
                commentTransformer.toCommentDtos(r.getComments())))
        .collect(Collectors.toList());
    }
}
