package cookbook;

import cookbook.domain.Recipe;
import cookbook.service.comment.CommentService;
import cookbook.view.comment.CommentView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CommentMenu {

    @Autowired
    private CommentService commentService;

    @Autowired
    private CommentView commentView;

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

    }
}
