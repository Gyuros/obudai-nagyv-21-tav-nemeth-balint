package cookbook;

import cookbook.view.GeneralView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class App {

    @Autowired
    private CookMenu cookMenu;

    @Autowired
    private GeneralView generalView;

    public void start() {
       generalView.printWelcome();
       cookMenu.printMainMenu();
    }
}
