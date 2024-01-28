import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        try {
            File file = new File("dane.txt");
            PrintWriter printWriter = new PrintWriter("wynik.txt");
            Scanner scanner = new Scanner(file);

            while(scanner.hasNext()) {
                int liczba1 = scanner.nextInt();
                String dzialanie = scanner.next();
                int liczba2 = scanner.nextInt();

                int wynik = oblicz(liczba1, dzialanie, liczba2);
                printWriter.println(wynik);
            }

            printWriter.close();

        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku");
        }
    }

    public static int oblicz(int liczba1, String dzialanie, int liczba2) {
        switch (dzialanie) {
            case "+":
                return liczba1 + liczba2;
            case "-":
                return liczba1 - liczba2;
            case "*":
                return liczba1 * liczba2;
            case "/":
                if (liczba2 == 0) {
                    throw new ArithmeticException("Nie można dzielić przez zero");
                }
                return liczba1 / liczba2;
            default:
                throw new IllegalArgumentException("Nieobsługiwane działanie: " + dzialanie);
        }
    }
}
