import java.io.IOException;

class Main {
    private static final String SOURCE_FILE_NAME = "operations.txt";
    private static final String TARGET_FILE_NAME = "results.txt";

    public static void main(String[] args) throws IOException {
        String[] data = FileUtils.readData(SOURCE_FILE_NAME);
        String[] calculatedData = DataUtils.calculateData(data);
        FileUtils.saveData(TARGET_FILE_NAME, calculatedData);
        FileUtils.printText(TARGET_FILE_NAME);
    }
}