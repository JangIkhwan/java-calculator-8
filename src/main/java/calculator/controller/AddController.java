package calculator.controller;

import calculator.model.Adder;
import calculator.view.InputView;
import calculator.view.OutputView;

public class AddController {
    private final Adder adder;
    private final InputView inputView;
    private final OutputView outputView;

    public AddController(Adder adder, InputView inputView, OutputView outputView){
        this.adder = adder;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run(){
        int[] positiveIntegers = inputView.inputPositiveIntegers();
        long result = adder.add(positiveIntegers);
        outputView.printResult(result);
    }

}
