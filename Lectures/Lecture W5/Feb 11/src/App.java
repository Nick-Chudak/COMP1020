import java.io.FileNotFoundException;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {

        ArrayList<String> words = new ArrayList<String>();
        words.add("Hello");
        words.add("World");
        words.add(0, "Programming");
        System.out.println(words);

        // Checked exceptions
        // IndexOutOfBoundException; FileNotFound exception, NumberFormatException;

        // Unchecked excpetions
        // IOException, FileNotFoundException

        
    }   
}
