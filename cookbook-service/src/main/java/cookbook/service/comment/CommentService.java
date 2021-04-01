package cookbook.service.comment;

import cookbook.domain.Comment;
import cookbook.domain.Recipe;
import cookbook.service.BaseService;

public interface CommentService extends BaseService<Comment> {

    void saveComment(Recipe recipe, String comment);
}
