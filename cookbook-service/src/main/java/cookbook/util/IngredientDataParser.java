package cookbook.util;

import cookbook.domain.Unit;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class IngredientDataParser extends BaseDataParser<Ingredient> {

    @Override
    public List<Ingredient> parse(String text) {
        return Arrays.stream(text.split("\r\n"))
                .filter(x -> !x.isEmpty())
                .map(line -> {
                    String[] values = line.split(" ");

                    double amount = Double.parseDouble(values[0]);
                    String name = values[2];
                    Unit unit = Unit.valueOf(values[1]);

                    return new Ingredient(
                            amount,
                            name,
                            unit);
                })
                .collect(Collectors.toList());
    }
}
