package cookbook.view.comment;

import cookbook.service.dto.RecipeDto;

public interface CommentView {
    void printRecipeComments(RecipeDto recipe);

    void printNewCommentForm();
}
