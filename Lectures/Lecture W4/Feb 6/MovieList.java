// Step 1: Define the MovieList class and declare private fields: movies array and count
class MovieList {
    
    private Movie[] movies;
    private int count;

    // Step 2: Implement the constructor to initialize the fields

    public MovieList(int count) {
        this.movies = new Movie[count];
        this.count = count;
    }
    // Step 3: Implement the findOrCreateMovie method to find a movie by title or create a new one
    
    public Movie findOrCreateMovie(String title) {
        Movie foundMovie = null;
        for (int i = 0; i < this.movies.length; i++) {

            if (this.movies[i].getTitle() == title) {
                return movies[i];
            }
        }

        if(foundMovie == null) {
            foundMovie = new Movie(title, review, rating);
            movies[count] += 1
    }
    }

    // Step 4: Implement the saveAllMovies method to save all movies to files
    
    public void saveAllMovies() {

    for (int i = 0; i < this.count; i++) {
        movies[i].saveToFile();
        }
    }
}