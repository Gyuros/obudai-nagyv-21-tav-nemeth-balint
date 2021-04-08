package cookbook.configuration;

import cookbook.domain.Identifiable;
import cookbook.service.BaseService;
import cookbook.service.comment.CommentService;
import cookbook.service.comment.CookbookCommentService;
import cookbook.service.cook.CookService;
import cookbook.service.cook.CookbookCookService;
import cookbook.service.recipe.CookbookRecipeService;
import cookbook.service.recipe.RecipeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class CookbookConfiguration {

    @Bean
    public CookService cookService(ApplicationContext context) {
        var cookService = context.getBean(CookbookCookService.class);
        init(cookService);
        return cookService;
    }

    @Bean
    public CommentService commentService(ApplicationContext context) {
        var commentService = context.getBean(CookbookCommentService.class);
        var cookService = context.getBean(CookbookCookService.class);
        init(commentService);
        cookService.add(commentService);
        return commentService;
    }

    @Bean
    public RecipeService recipeService(ApplicationContext context) {
        var recipeService = context.getBean(CookbookRecipeService.class);
        var cookService = context.getBean(CookbookCookService.class);
        init(recipeService);
        cookService.add(recipeService);
        return recipeService;
    }

    private <T extends Identifiable> void init(BaseService<T> service) {
        try {
            service.init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
