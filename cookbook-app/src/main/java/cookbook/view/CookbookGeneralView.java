package cookbook.view;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class CookbookGeneralView extends BaseView implements GeneralView {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public void printWelcome() {
        print(
                "-- Application started --",
                "-- Welcome to the Cookbook application! --",
                "");
    }

    @Override
    public String getInput() {
        return scanner.nextLine();
    }
}
