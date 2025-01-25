import java.util.Scanner;
import java.util.PriorityQueue;

public class ValueFinder {

    @SuppressWarnings("unchecked")
    public static <T> TrieST<T> getTries(String data) {
        Scanner sc = new Scanner(data);

        TrieST<T> tries = new TrieST<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");

            for (int i = 0; i < parts.length; i++) {
                if (parts[i].charAt(parts[i].length() - 1) == '.' || parts[i].charAt(parts[i].length() - 1) == ','
                        || parts[i].charAt(parts[i].length() - 1) == ','
                        || parts[i].charAt(parts[i].length() - 1) == '!'
                        || parts[i].charAt(parts[i].length() - 1) == '?'
                        || parts[i].charAt(parts[i].length() - 1) == ':'
                        || parts[i].charAt(parts[i].length() - 1) == ';')
                    parts[i] = parts[i].substring(0, parts[i].length() - 1);
                parts[i] = parts[i].toLowerCase();

                tries.put(parts[i], (T) parts[i]);
            }
        }
        sc.close();

        // tries.printAll();
        // System.out.println("checkpoint!");
        return tries;
    }

}
