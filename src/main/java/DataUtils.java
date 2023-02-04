import java.util.Arrays;

public class DataUtils {

    private static final String SUM = "+";
    private static final String SUBTRACT = "-";
    private static final String MULTIPLY = "*";
    private static final String DIVIDE = "/";

    public static String[] calculateData(String[] data) {
        String[] calculatedData = Arrays.copyOf(data, data.length);
        for (int i = 0; i < data.length; i++) {
            String[] separatedData = data[i].split(" ");
            calculateAndSaveResult(calculatedData, i, separatedData);
        }
        return calculatedData;
    }

    private static void calculateAndSaveResult(String[] calculatedData, int i, String[] separatedData) {
        double firstNumber = Double.parseDouble(separatedData[0]);
        double secondNumber = Double.parseDouble(separatedData[2]);
        String operator = separatedData[1];
        switch (operator) {
            case SUM -> calculatedData[i] += (" = " + (firstNumber + secondNumber));
            case SUBTRACT -> calculatedData[i] += (" = " + (firstNumber - secondNumber));
            case MULTIPLY -> calculatedData[i] += (" = " + (firstNumber * secondNumber));
            case DIVIDE -> calculatedData[i] += (" = " + (firstNumber / secondNumber));
            default -> System.err.print("Nie rozpoznano operacji do wykonania");
        }
    }
}