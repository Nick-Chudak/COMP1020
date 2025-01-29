import javax.lang.model.type.NullType;

public class Library {
    private String title ;
    private String address;
    private Book[] books;
    private int bookCount;
    private Person[] members;
    private int memberCount;

    private int staffCount;
    private Person[] staff;

    public Library(String title, String address, int librarySize) {

        this.title = title;
        this.address = address;
        this.books = new Book[librarySize];
        this.bookCount = 0;
    }
    

    public void addBook (Book b) {
        boolean wasAdded = false;
        if(bookCount < books.length) {

            books[bookCount] = b;
            bookCount++;
            wasAdded = !wasAdded
        }
    }

    public boolean removeBook (Book bookToRemove) {
        boolean wasRemoved = false;

        for (int i = 0; i < bookCount; i++) {

            if (books[i].equals(bookToRemove)) {

                for(int j = 1; j < bookCount - 1; j++) {
                    books[j] = books[j + 1];
                }

                bookCount--;
                wasRemoved = !wasRemoved; 
            }
            }
        return wasRemoved;
        }
    }
}
