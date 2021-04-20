package cookbook.service.comment;

import cookbook.persistence.entity.Comment;
import cookbook.persistence.repository.CommentRepository;
import cookbook.persistence.repository.CookRepository;
import cookbook.persistence.repository.RecipeRepository;
import cookbook.service.cook.CookbookCookService;
import cookbook.service.dto.RecipeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CookbookCommentService implements CommentService {

    @Autowired
    private CookbookCookService cookService;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private CookRepository cookRepository;

    @Override
    public void saveComment(RecipeDto recipe, String comment) {
        var r = recipeRepository.findById(recipe.getId()).get();
        var c = cookRepository.findById(cookService.getCurrentUser().getId()).get();
        commentRepository.save(new Comment(comment, r, c));
    }
}
