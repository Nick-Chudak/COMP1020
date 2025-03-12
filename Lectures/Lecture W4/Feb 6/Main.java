import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Step 1: Create a MovieList object with a specified size
        MovieList movieList = new MovieList(50);

        Movie myMovie = new Movie("My mvoies", "Not bad", 3);

        myMovie.saveToFile();

        // Step 2: Read the reviews from a file
        try (BufferReader br = new BufferReader(new FileReader("reviews.txt")))
        {
            String line;
            line = br.readLine();
            

            while ((line = br.readLine()) != null) {
                // Step 3: Extract the movie title, review, and rating from each line
                
                line = sc.nextLine();

                movieList.addMovie()

                // Step 4: Find or create the movie and add the review
                

            }
            // Step 5: Save all movies to files
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}