package cookbook.util;

import java.util.List;

public interface DataParser<T> {

    List<T> parse(String text);

    String toString(List<T> models);
}
