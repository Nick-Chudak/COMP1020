// Step 1: Import necessary classes for file handling
import java.io.*;
import java.util.*;

// Step 2: Define the Movie class and declare private fields: title, totalScore, reviewCount, and reviews
class Movie {
   
    String title;
    int totalScore;
    int reviewCount; 
    String[] reviews = new String[50];
    int[] ratings = new int[50];

    // Step 3: Implement the constructor to initialize the fields

    public Movie(String title, String review, int rating) {
        this.title = title;
        this.reviews[reviewCount] = review;
        this.ratings[reviewCount] = rating;
        this.totalScore += rating;
        this.reviewCount += 1;
    }

    // Step 4: Implement the addReview method to add a review and rating
   
    public void addReview(String review, int rating) {
        this.reviews[reviewCount] = review;
        this.totalScore += rating;
        this.reviewCount += 1;
    }

    // Step 5: Implement the getAverageScore method to calculate the average score

    public double getAverageScore() {
        return (this.totalScore / this.reviewCount);
    }
   

    // Step 6: Implement the getTitle method to return the title of the movie

    public String getTitle() {
        return this.title;
    }

    // Step 7: Implement the saveToFile method to save the movie details and reviews to a file

    public void saveToFile() {
        try {
            FileWriter fw = new FileWriter("./MovieReviews/reviews.txt");
            PrintWriter pw = new PrintWriter(fw);
            for (int i = 0; i < reviewCount; i++) {
                String line = this.title + ", " + this.reviews[i] + ", " + this.ratings[i];
                pw.println(line);
            }
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}