package cookbook.view;

import org.springframework.stereotype.Component;

@Component
public class CookbookGeneralView extends BaseView implements GeneralView {
    @Override
    public void printWelcome() {
        print(
                "-- Application started --",
                "-- Welcome to the Cookbook application! --");
    }

    @Override
    public String getInput() {
        return null;
    }
}
