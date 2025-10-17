package calculator;

public class InputParser {
    private static final String delimitChars = ",:";
    private static final String delimitersToDoubleSlash = ".*+?^$()[]{}\\";
    private static String customDelimiter = "";

    public int[] getPositiveIntegers(String line) {
        // 앞에 커스텀 구분자가 있다면 구분자 변경
        String removedPrefix = parsePrefix(line);

        // 구분자로 구분하여서 입력을 정수 배열로 변환
        return parsePositiveIntegers(removedPrefix);
    }

    private static int[] parsePositiveIntegers(String line) {
        String[] tokens = line.split("[" + delimitChars + customDelimiter + "]");
        int[] positiveIntegers = new int[tokens.length];
        for (int i = 0; i < positiveIntegers.length; i++) {
            try {
                positiveIntegers[i] = Integer.parseInt(tokens[i]);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 형식의 입력입니다");
            }

            if (positiveIntegers[i] < 0) {
                throw new IllegalArgumentException("입력은 0 또는 양수이어야 합니다");
            }
        }
        return positiveIntegers;
    }

    private static String parsePrefix(String line){
        String[] toks = line.split("\\\\n");
        if(toks.length > 2){
            throw new IllegalArgumentException("잘못된 형식의 입력입니다.");
        }
        if(toks.length == 1){
            return toks[0];
        }

        String prefix = toks[0];
        if(!(prefix.startsWith("//") && prefix.length() == 3)){
            throw new IllegalArgumentException("잘못된 형식의 입력입니다.");
        }

        String delimiter = prefix.substring(2, 3);
        if(delimiter.equals("\\")){
            delimiter = "\\\\";
        }
        else if(delimitersToDoubleSlash.contains(delimiter)){
            delimiter = "\\" + delimiter;
        }
        customDelimiter = delimiter;

        return toks[1];
    }
}
