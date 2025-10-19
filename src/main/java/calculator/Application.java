package calculator;

import calculator.controller.AddController;
import calculator.model.Adder;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputParser parser = new InputParser();
        Adder adder = new Adder();
        InputView inputView = new InputView(parser);
        OutputView outputView = new OutputView();
        AddController controller = new AddController(adder, inputView, outputView);
        controller.run();
    }
}
