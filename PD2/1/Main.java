import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            File inputFile = new File("dane.txt");
            PrintWriter writer = new PrintWriter("wynik.txt");
            Scanner scanner = new Scanner(inputFile);
            PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("\\{|\\}");

                if (parts.length == 2) {
                    int priority = Integer.parseInt(parts[1]);
                    queue.offer(priority);
                } else if (line.equals("drukuj")) {
                    if (!queue.isEmpty()) {
                        int highestPriority = queue.poll();
                        writer.println(highestPriority);
                    } else {
                        writer.println("brak");
                    }
                } else if (line.equals("koniec")) {
                    while (!queue.isEmpty()) {
                        int priority = queue.poll();
                        writer.println(priority);
                    }
                }
            }

            scanner.close();
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku");
        }
    }
}
