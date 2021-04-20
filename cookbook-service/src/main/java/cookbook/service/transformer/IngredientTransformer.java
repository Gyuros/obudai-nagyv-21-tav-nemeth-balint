package cookbook.service.transformer;

import cookbook.persistence.entity.Ingredient;
import cookbook.service.dto.IngredientDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class IngredientTransformer {

    public List<Ingredient> transform(List<IngredientDto> ingredients) {
        return ingredients.stream().map(i -> new Ingredient(i.getAmount(), i.getName(), i.getUnit())).collect(Collectors.toList());
    }

    public List<IngredientDto> transform(List<Ingredient> ingredients) {
        return ingredients.stream().map(i -> new IngredientDto(i.getAmount(), i.getName(), i.getUnit())).collect(Collectors.toList());
    }
}
