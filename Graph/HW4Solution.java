import java.io.IOException;
import java.util.Scanner;

public class HW4Solution {
    static TrieST<Object> tries;

    public static void main(String[] args) throws IOException {

        tries = FileRead.<Object>readTries("Input1.txt");

        Scanner sc = new Scanner(System.in);
        String operation = sc.next();
        String data = sc.next().toLowerCase();
        String data2 = "";
        if (sc.hasNext())
            data2 = sc.next();

        switch (operation) {
            case "search":
                boolean b = Search(data);
                System.out.println(b);
                break;
            case "autocomplete":
                autoComplete(data);
                break;
            case "reverse":
                reverseAutoComplete(data);
                break;
            case "full":
                FullAutoComplete(data, data2);
                break;
            case "topk":
                findTopK(Integer.parseInt(data));
                break;
        }
    }

    static Boolean Search(String arg) {
        return tries.get(arg) != null;
    }

    static void autoComplete(String prefix) {
        boolean notFound = true;
        for (String key : tries.keysWithPrefix(prefix)) {
            if (notFound)
                System.out.print(key);
            else
                System.out.print(", " + key);
            notFound = false;
        }
        if (notFound)
            System.out.println("No Words");
    }

    static void reverseAutoComplete(String suffix) {
        boolean notFound = true;
        for (String key : tries.keysWithSuffix(suffix)) {
            if (notFound)
                System.out.print(key);
            else
                System.out.print(", " + key);
            notFound = false;
        }
        if (notFound)
            System.out.println("No Words");
    }

    static void FullAutoComplete(String prefix, String suffix) {
        boolean notFound = true;
        for (String key : tries.keysWithPrefixSuffix(prefix, suffix)) {
            if (notFound)
                System.out.print(key);
            else
                System.out.print(", " + key);
            notFound = false;
        }
        if (notFound)
            System.out.println("No Words");
    }

    static void findTopK(int k) {
        boolean notFound = true;
        for (String key : tries.getTop(k)) {
            if (notFound)
                System.out.print(key);
            else
                System.out.print(", " + key);
            notFound = false;
        }
        if (notFound)
            System.out.println("No Words");
    }
}
