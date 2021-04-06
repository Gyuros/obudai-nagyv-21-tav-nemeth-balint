package cookbook.service.category;

import cookbook.domain.Category;

import java.util.Set;

public class CookbookCategoryService implements CategoryService {

    private Set<Category> categories = Set.of(Category.values());

    @Override
    public Set<Category> getCategories() {
        return categories;
    }
}
