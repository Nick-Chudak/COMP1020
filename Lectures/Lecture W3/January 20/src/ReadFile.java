import java.io.*;

public class ReadFile {

    public static void main(String[] args[]) {

        try {
            FileReader fr = new FileReader("file.txt");
            BufferedReader br = new BufferedReader(fr);

            String line = br.readLine();
        }
        catch(FileNotFoundException e) {
            System.out.println("File not found.");
        }
        catch(IOException e) {
            System.out.println("An error occurred " + e.getMessage());
        }
    }
    
}
