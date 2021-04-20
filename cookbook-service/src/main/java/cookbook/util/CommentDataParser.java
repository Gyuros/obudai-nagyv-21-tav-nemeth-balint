package cookbook.util;

import cookbook.exception.ModelNotFoundException;
import cookbook.service.cook.CookService;
import cookbook.service.recipe.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CommentDataParser extends BaseDataParser<Comment> {

    @Autowired
    private CookService cookService;

    @Autowired
    private RecipeService recipeService;

    @Override
    public List<Comment> parse(String text) throws ModelNotFoundException {
        return Arrays.stream(text.split("\r\n"))
                .map(line -> {
                    String[] values = line.split(" ");

                    long id = Long.parseLong(values[0]);
                    String description = String.join(" ", Arrays.copyOfRange(values, 4, values.length));
                    LocalDateTime timestamp = LocalDateTime.parse(values[3]);
                    long ownerId = Long.parseLong(values[2]);
                    long recipeId = Long.parseLong(values[1]);

                    return new Comment(
                            id,
                            description,
                            timestamp,
                            cookService.findById(ownerId),
                            recipeService.findById(recipeId));
                })
                .collect(Collectors.toList());
    }
}
