class Main{
    public static void main(String[] args){
        System.out.println("Hello World");
        Person p1 = new Person("John", 30);
        Person p2 = new Person();

        Person p3 = p1.clone(); // a deep copy of p1 is created 
        // and p3 points to it.

        Person p4 = new Person(p2); // p2 is passed to the copy constructor 
        //and p4 points to the person created.

        Book b1 = new Book("Gone wtih the Wind", "GW123");
        Book b2 = new Book("The Great Gatsby", "GG123");

        b1.setBorrower(p1);
        System.out.println(p1);
    }
}
