package cookbook;

import cookbook.view.GeneralView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class App {

    @Autowired
    private CommentMenu commentMenu;

    @Autowired
    private CookMenu cookMenu;

    @Autowired
    private RecipeMenu recipeMenu;

    @Autowired
    private GeneralView generalView;

    public void start() {
       init();
       generalView.printWelcome();
       cookMenu.printMainMenu();
    }

    private void init() {
        cookMenu.init();
        recipeMenu.init();
        commentMenu.init();
    }
}
