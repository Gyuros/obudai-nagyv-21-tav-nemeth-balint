package cookbook;

import cookbook.service.HelloService;
import cookbook.view.HelloView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class App {

    @Autowired
    private HelloView helloView;

    @Autowired
    private HelloService helloService;

    public void start() {
        helloView.print(helloService.get());
    }
}
