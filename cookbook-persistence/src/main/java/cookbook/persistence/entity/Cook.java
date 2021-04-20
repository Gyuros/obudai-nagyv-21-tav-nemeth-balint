package cookbook.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cook extends User {

    public Cook() {
    }

    public Cook(String username, String password) {
        super(username, password);
    }

    @OneToMany(mappedBy = "uploader")
    private List<Recipe> ownRecipes = new ArrayList<>();

    @OneToMany(mappedBy = "recipe")
    private List<Comment> comments = new ArrayList<>();

    public List<Recipe> getOwnRecipes() {
        return ownRecipes;
    }

    public List<Comment> getComments() {
        return comments;
    }


}
