package cookbook.service;

import org.springframework.stereotype.Component;

@Component
public class HelloService {

    public String get() {
        return "Hello World!";
    }
}
