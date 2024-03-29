package cookbook.service.recipe;

import com.google.common.collect.Lists;
import cookbook.exception.ModelNotFoundException;
import cookbook.persistence.repository.CookRepository;
import cookbook.persistence.repository.RecipeRepository;
import cookbook.service.dto.RecipeDto;
import cookbook.service.transformer.RecipeTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class CookbookRecipeService implements RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private CookRepository cookRepository;

    @Autowired
    private RecipeTransformer transformer;

    @Override
    public void addRecipe(RecipeDto recipe) {
        var saved = recipeRepository.save(transformer.toRecipe(recipe));
        recipe.setId(saved.getId());
    }

    @Override
    @Transactional
    public List<RecipeDto> getRecipes() {
        return transformer.toRecipeDtos(Lists.newArrayList(recipeRepository.findAll()));
    }

    @Override
    public void deleteRecipe(String id) throws ModelNotFoundException {
        var removable = recipeRepository.findById(Long.parseLong(id));

        if(!removable.isPresent())
            throw new ModelNotFoundException("Model not found.");

        recipeRepository.delete(removable.get());
    }

    @Override
    @Transactional
    public RecipeDto getRefreshed(RecipeDto recipe) {
        return transformer.toRecipeDto(recipeRepository.findById(recipe.getId()).get());
    }
}
