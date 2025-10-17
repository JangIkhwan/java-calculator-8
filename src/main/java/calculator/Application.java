package calculator;

public class Application {
    public static void main(String[] args) {
        InputParser parser = new InputParser();
        Adder adder = new Adder(parser);
        adder.execute();
    }
}
