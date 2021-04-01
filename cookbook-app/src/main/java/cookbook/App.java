package cookbook;

import cookbook.service.cook.CookService;
import cookbook.service.comment.CommentService;
import cookbook.service.recipe.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class App {

    @Autowired
    private CookService cookService;

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private CommentService commentService;

    public void start() {
        try {
            cookService.init();
            recipeService.init();
            commentService.init();
            cookService.add(recipeService);
            cookService.add(commentService);
            cookService.logout();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
