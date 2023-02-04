import java.io.*;
import java.util.Scanner;

public class FileUtils {

    public static String[] readData(String fileName) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            String[] lines = new String[countLines(fileName)];
            for (int i = 0; i < lines.length; i++) {
                lines[i] = scanner.nextLine();
            }
            System.out.println("Wczytano plik " + fileName);
            return lines;
        }
    }

    public static void saveData(String fileName, String[] dataToSave) {
        try (
                var fileWriter = new FileWriter(fileName);
                var bufferedWriter = new BufferedWriter(fileWriter)
        ) {
            for (String data : dataToSave) {
                bufferedWriter.write(data + "\n");
            }
        } catch (IOException e) {
            System.err.print("Nie udało się zapisać pliku");
        }
    }

    public static void printText(String fileName) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        }
    }

    private static int countLines(String fileName) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            int lines = 0;
            while (scanner.hasNextLine()) {
                scanner.nextLine();
                lines++;
            }
            scanner.close();
            return lines;
        }
    }
}