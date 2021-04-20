package cookbook.service.comment;

import cookbook.service.dto.RecipeDto;

public interface CommentService {

    void saveComment(RecipeDto recipe, String comment);
}
