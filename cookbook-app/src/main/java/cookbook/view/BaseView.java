package cookbook.view;

public class BaseView {

    protected void print(String... lines) {
        for(String line : lines) {
            System.out.println(line);
        }
        System.out.println();
    }

    protected void print(Object... lines) {
        for(Object line : lines) {
            System.out.println(line);
        }
        System.out.println();
    }
}
