package cookbook.service.comment;

import cookbook.persistence.repository.CommentRepository;
import cookbook.persistence.repository.RecipeRepository;
import cookbook.service.CookbookBaseService;
import cookbook.service.cook.CookbookCookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.security.auth.login.CredentialNotFoundException;

@Component
public class CookbookCommentService extends CookbookBaseService<Comment> implements CommentService {

    @Autowired
    private CookbookCookService cookService;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private RecipeRepository recipeRepository;

    public CookbookCommentService() {
        super("comments.txt");
    }

    @Override
    public void saveComment(Recipe recipe, String comment) {
//        long lastId = models.stream()
//                .map(Comment::getId)
//                .max(Long::compare)
//                .orElse(1L);
//
//        Comment newComment = new Comment(
//                lastId + 1,
//                comment,
//                LocalDateTime.now(),
//                cookService.getCurrentUser(),
//                recipe);
//
//        models.add(newComment);
//        var r = recipeRepository.findById(recipe.getId()).get();
//        var c =  cookService.getCurrentUser()
//
//        commentRepository.save(new cookbook.persistence.entity.Comment(comment, r, ))
    }

    @Override
    public void deleteCommentsForRecipe(Recipe recipe) throws CredentialNotFoundException {
        if(recipe.getUploader() != cookService.getCurrentUser())
            throw new CredentialNotFoundException();

        recipe.getComments().forEach(this::deleteComment);
    }

    private void deleteComment(Comment comment) {
        comment.getOwner().getComments().remove(comment);
        models.remove(comment);
    }
}
