package calculator.model;

public class Adder {
    public long add(int[] positiveIntegers) {
        long sum = 0;
        for(int i = 0; i < positiveIntegers.length; i++){
            sum += positiveIntegers[i];
        }
        return sum;
    }
}
