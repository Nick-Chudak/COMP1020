public class Book {
    private String title;
    private String ISBN;
    private Person borrower;

    public Book(String title, String ISBN){
        this.title = title;
        this.ISBN = ISBN;
    }

    public void setBorrower(Person borrower){
        this.borrower = borrower;
        borrower.setBorrowedBook(this);
    }


    public String getTitle(){
        return this.title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    
    public String toString(){
        String result = String.format("Title: %s, ISBN: %s", this.title, this.ISBN);
        if(borrower != null){
            result += String.format("  " + borrower.toString());
        }
        return result;
    }
}
