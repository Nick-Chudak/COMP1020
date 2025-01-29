public class Classroom {
    
    String className;
    StudentList studentlist;
    
    public Classroom(String name, int capacity) {
        this.className = name;
        
    }


    public String toString() {
        return "Class name: " + this.className + "\n" + studentlist.toString();
    }
}
