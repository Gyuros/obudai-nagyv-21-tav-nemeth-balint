package cookbook.util;

import cookbook.domain.Cook;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CookDataParser implements DataParser<Cook> {

    @Override
    public List<Cook> parse(String text) {
        return Arrays.stream(text.split("\r\n"))
                .filter(x -> !x.isEmpty())
                .map(line -> {
                    String[] values = line.split(" ");

                    long id = Integer.parseInt(values[0]);
                    String username = values[1];
                    String password = values[2];

                    return new Cook(
                            id,
                            username,
                            password);
                })
                .collect(Collectors.toList());
    }

    @Override
    public String toString(List<Cook> models) {
        return models.stream().map(Cook::toString).collect(Collectors.joining(System.lineSeparator()));
    }
}
