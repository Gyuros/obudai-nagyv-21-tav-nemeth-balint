package cookbook.view.comment;

import cookbook.domain.Recipe;

public interface CommentView {
    void printRecipeComments(Recipe recipe);

    void printNewCommentForm();
}
