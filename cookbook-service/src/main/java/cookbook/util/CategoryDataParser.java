package cookbook.util;

import cookbook.domain.Category;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryDataParser implements DataParser<Category> {

    @Override
    public List<Category> parse(String text) {
        return Arrays.stream(text.split("\r\n"))
                .filter(x -> !x.isEmpty())
                .map(Category::valueOf)
                .collect(Collectors.toList());
    }
}
