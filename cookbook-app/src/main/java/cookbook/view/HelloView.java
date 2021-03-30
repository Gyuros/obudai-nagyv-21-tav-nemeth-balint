package cookbook.view;

import org.springframework.stereotype.Component;

@Component
public class HelloView {

    public void print(String text) {
        System.out.println(text);
    }
}
