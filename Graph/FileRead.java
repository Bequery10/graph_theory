import java.io.FileReader;
import java.io.IOException;

public class FileRead {

    public static <T> TrieST<T> readTries(String url) throws IOException {

        FileReader reader = new FileReader(url);

        int data = reader.read();
        String string = "";

        while (data != -1) {
            string += (char) data;
            data = reader.read();
        }

        return ValueFinder.<T>getTries(string);
    }

}
