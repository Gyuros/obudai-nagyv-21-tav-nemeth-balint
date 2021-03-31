package cookbook.domain;

import java.util.List;

public class Cook extends User {

    private List<Recipe> ownRecipes;

    public Cook(long id, String username, String password) {
        super(id, username, password);
    }

    public List<Recipe> getOwnRecipes() {
        return ownRecipes;
    }
}
