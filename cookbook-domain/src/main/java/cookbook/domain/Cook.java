package cookbook.domain;

import java.util.ArrayList;
import java.util.List;

public class Cook extends User {

    private List<Recipe> ownRecipes = new ArrayList<>();
    private List<Comment> comments = new ArrayList<>();

    public Cook(long id, String username, String password) {
        super(id, username, password);
    }

    public Cook(String username, String password) {
        super(username, password);
    }

    public List<Recipe> getOwnRecipes() {
        return ownRecipes;
    }

    public List<Comment> getComments() {
        return comments;
    }


}
