package cookbook.service.comment;

import cookbook.domain.Recipe;

public interface CommentService {

    void saveComment(Recipe recipe, String comment);
}
