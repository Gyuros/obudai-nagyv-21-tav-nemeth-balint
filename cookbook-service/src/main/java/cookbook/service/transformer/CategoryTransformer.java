package cookbook.service.transformer;

import cookbook.domain.Category;
import cookbook.persistence.entity.RecipeCategory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryTransformer {

    public List<RecipeCategory> transform(List<Category> categories) {
        return categories.stream().map(RecipeCategory::new).collect(Collectors.toList());
    }

    public List<Category> transform(List<RecipeCategory> categories) {
        return categories.stream().map(c -> c.getCategory()).collect(Collectors.toList());
    }
}
