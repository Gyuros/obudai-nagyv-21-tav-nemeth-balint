package cookbook.service.transformer;

import cookbook.persistence.entity.Ingredient;
import cookbook.persistence.entity.Recipe;
import cookbook.service.dto.IngredientDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class IngredientTransformer {

    public List<Ingredient> toIngredients(List<IngredientDto> ingredients, Recipe recipe) {
        return ingredients.stream().map(i -> new Ingredient(i.getAmount(), i.getName(), i.getUnit(), recipe)).collect(Collectors.toList());
    }

    public List<IngredientDto> toIngredientDtos(List<Ingredient> ingredients) {
        return ingredients.stream().map(i -> new IngredientDto(i.getAmount(), i.getName(), i.getUnit())).collect(Collectors.toList());
    }
}
