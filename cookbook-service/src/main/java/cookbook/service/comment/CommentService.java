package cookbook.service.comment;

import cookbook.domain.Comment;
import cookbook.domain.Recipe;
import cookbook.service.BaseService;
import cookbook.service.Observable;

import javax.security.auth.login.CredentialNotFoundException;

public interface CommentService extends BaseService<Comment>, Observable {

    void saveComment(Recipe recipe, String comment);

    void deleteCommentsForRecipe(Recipe recipe) throws CredentialNotFoundException;
}
