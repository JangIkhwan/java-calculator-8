package calculator.view;

public class InputParser {
    private static final String delimitChars = ",:";
    private static final String delimitersToDoubleSlash = ".*+?^$()[]{}\\";

    public int[] getPositiveIntegers(String line) {
        if(line.isEmpty()){
            return new int[] {};
        }

        if(hasCustomDelimiter(line)){
            String[] toks = line.split("\\\\n");
            String customDelimiter = getCustomDelimiter(toks[0]);
            return parsePositiveIntegers(toks[1], customDelimiter);
        }

        return parsePositiveIntegers(line, "");
    }

    private boolean hasCustomDelimiter(String line){
        String prefix = line.split("\\\\n")[0];
        return prefix.startsWith("//") && prefix.length() == 3;
    }

    private static int[] parsePositiveIntegers(String line, String customDelimiter) {
        String[] tokens = line.split("[" + delimitChars + customDelimiter + "]");
        int[] positiveIntegers = new int[tokens.length];
        for (int i = 0; i < positiveIntegers.length; i++) {
            try {
                positiveIntegers[i] = Integer.parseInt(tokens[i]);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 형식의 입력입니다");
            }

            if (positiveIntegers[i] <= 0) {
                throw new IllegalArgumentException("입력은 양수이어야 합니다");
            }
        }
        return positiveIntegers;
    }

    private static String getCustomDelimiter(String prefix){
        String delimiter = prefix.substring(2, 3);
        if(delimitersToDoubleSlash.contains(delimiter)){
            delimiter = "\\" + delimiter;
        }
        return delimiter;
    }
}
