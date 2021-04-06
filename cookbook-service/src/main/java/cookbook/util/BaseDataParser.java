package cookbook.util;

import java.util.List;
import java.util.stream.Collectors;

public abstract class BaseDataParser<T> implements DataParser<T> {

    public abstract List<T> parse(String text);

    public String toString(List<T> models) {
        return models.stream().map(T::toString).collect(Collectors.joining(System.lineSeparator()));
    }
}