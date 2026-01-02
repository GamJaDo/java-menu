package menu.controller;

import java.util.List;
import menu.domain.Person;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        inputView.menuRecommendation();
        List<Person> persons = inputPersonNameTry();
    }

    private List<Person> inputPersonNameTry() {
        while (true) {
            try {
                return inputView.inputPersonNames();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
