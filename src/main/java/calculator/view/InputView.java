package calculator.view;

import calculator.InputParser;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final InputParser parser;

    public InputView(InputParser parser){
        this.parser = parser;
    }
    public int[] inputPositiveIntegers() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String line = Console.readLine();
        return parser.getPositiveIntegers(line);
    }
}
