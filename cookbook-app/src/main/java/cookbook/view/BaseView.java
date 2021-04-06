package cookbook.view;

public class BaseView {
    protected void print(String... lines) {
        for(String line : lines) {
            System.out.println(line);
        }
    }
}
