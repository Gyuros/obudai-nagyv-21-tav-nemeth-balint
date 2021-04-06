package cookbook.view;

public class BaseView {

    protected void print(String... lines) {
        for(String line : lines) {
            System.out.println(line);
        }
    }

    protected void print(Object... lines) {
        for(Object line : lines) {
            System.out.println(line);
        }
    }

    protected void println() {
        System.out.println();
    }
}
