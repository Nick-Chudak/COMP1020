public class Person {
    private String name;
    private int age;
    private Book borrowedBook;

    
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }
    public Person(){
        this.name = "Unknown";
        this.age = 0;
    }
    public Person(Person other){ // Copy constructor
        this.name = other.getName();
        this.age = other.getAge();
    }
    public Person clone(){
        return new Person(this); // or return new Person(this.name, this.age);
    }

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getAge(){
        return this.age;
    }
    public void setBorrowedBook(Book book){
        borrowedBook = book;
    }

    
    public String toString(){
        String result = String.format("Name: %s, Age: %d", this.name, this.age);
        if (borrowedBook != null){
            result += String.format("  " + borrowedBook.toString());
        }
        return result;
    }

}
