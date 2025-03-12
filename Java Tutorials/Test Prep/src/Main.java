import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    
    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\n" + //
                        "chud\\Desktop\\UofM\\COMP1020\\Java Tutorials\\Test Prep\\input.txt"))) {
            FileWriter fw = new FileWriter("./output.txt");
            String line = br.readLine();
            
            while (line != null) {
                String lineClean = line.replaceAll("[^a-zA-Z ]", "");
                String[] words = lineClean.split(" ");
                int count = 0;
                int totalLength = 0;

                for (int i = 0; i < words.length; i++) {
                    totalLength +=words[i].length();
                    count++;
                }

                fw.write(String.format("%.1f%n", (double) totalLength/count));
                line = br.readLine();

            }

            fw.close();

            System.out.println("324rre.234 f42".replaceAll("[a-zA-Z]", ""));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
