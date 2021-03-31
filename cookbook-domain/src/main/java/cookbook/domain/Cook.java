package cookbook.domain;

import java.util.List;

public class Cook extends User {

    private List<Recipe> ownRecipes;
    private List<Comment> comments;

    public Cook(long id, String username, String password) {
        super(id, username, password);
    }

    public List<Recipe> getOwnRecipes() {
        return ownRecipes;
    }

    public List<Comment> getComments() {
        return comments;
    }
}
