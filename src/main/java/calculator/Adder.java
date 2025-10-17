package calculator;

import camp.nextstep.edu.missionutils.Console;


public class Adder {
    private final InputParser parser;

    public Adder(InputParser parser){
        this.parser = parser;
    }

    public void execute() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String line = Console.readLine();

        int[] positiveIntegers = parser.getPositiveIntegers(line);
        long result = add(positiveIntegers);

        System.out.println("결과 : " + result);
    }

    private long add(int[] positiveIntegers) {
        long sum = 0;
        for(int i = 0; i < positiveIntegers.length; i++){
            sum += positiveIntegers[i];
        }
        return sum;
    }
}
