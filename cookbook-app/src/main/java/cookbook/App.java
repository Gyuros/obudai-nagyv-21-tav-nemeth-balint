package cookbook;

import cookbook.view.HelloView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class App {

    @Autowired
    private HelloView helloView;

    public void start() {
        helloView.helloWorld();
    }
}
