package cookbook.service.comment;

import cookbook.domain.Comment;
import cookbook.domain.Recipe;
import cookbook.service.BaseService;
import cookbook.service.Observable;

public interface CommentService extends BaseService<Comment>, Observable {

    void saveComment(Recipe recipe, String comment);
}
