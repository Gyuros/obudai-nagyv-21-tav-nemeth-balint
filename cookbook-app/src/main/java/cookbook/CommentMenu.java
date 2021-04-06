package cookbook;

import cookbook.domain.Recipe;
import cookbook.service.comment.CommentService;
import cookbook.service.cook.CookService;
import cookbook.view.GeneralView;
import cookbook.view.comment.CommentView;
import cookbook.view.cook.CookView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CommentMenu {

    @Autowired
    private CommentService commentService;

    @Autowired
    private CommentView commentView;

    @Autowired
    private CookService cookService;

    @Autowired
    private CookView cookView;

    @Autowired
    private GeneralView generalView;

    public void init() {
        try {
            commentService.init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void processRecipeMenuInput(Recipe recipe, String input) {
        switch (input){
            case "1": commentView.printRecipeComments(recipe); break;
            case "2": newComment(recipe); break;
        }
    }

    private void newComment(Recipe recipe) {
        if(cookService.isLoggedIn()) {
            commentView.printNewCommentForm();
            commentService.saveComment(recipe, generalView.getInput());
        } else {
            cookView.printNotAuthenticated();
        }
    }
}
