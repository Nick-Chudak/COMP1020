/**
 *
 * COMP 1020 SECTION A04
 * INSTRUCTOR    Pouya Aghahoseini
 * ASSIGNMENT    Homework W3
 * @author       Mykola Chudak, 8043157
 * @version      1/29/2025
 */

public class StudentList {
    Student[] students;
    int capacity;
    int currentStudentCount;

    // public static void main(String args[]) {
    //     StudentList students = new StudentList(5);
    //     Student student1 = new Student("John Doe1", 20, 3.5, "john.doe@example.com", "204-555-1111");
    //     Student student2 = new Student("John Din2", 20, 3.5, "john.doe@example.com", "204-555-1111");
    //     Student student3 = new Student("John Doe3", 20, 3.5, "john.doe@example.com", "204-555-1111");
    //     Student student4 = new Student("John Doe4", 20, 3.5, "john.doe@example.com", "204-555-1111");
    //     Student student5 = new Student("John Doe5", 20, 3.5, "john.doe@example.com", "204-555-1111");
    //     Student student6 = new Student("John Doe6", 20, 3.5, "john.doe@example.com", "204-555-1111");
        
    //     System.out.println(student2);

    //     students.addStudent(student1);
    //     students.addStudent(student2);
    //     students.addStudent(student3);
    //     students.addStudent(student4);
    //     students.addStudent(student5);
    //     students.addStudent(student6);

    //     students.removeStudent("John Doe5");
    //     students.addStudent(student6);

    //     System.out.println(students);
    // }
    
    public StudentList(int capacity) {
        this.students = new Student[capacity];
    }

    public void addStudent(Student student) {
        boolean isAdded = false;

        for (int i = 0; i < this.students.length; i++) {
            
            if (this.students[i] == null && isAdded == false) {
                students[i] = student;

                currentStudentCount++;
                isAdded = true;
            }
        }
        if (isAdded == false) {
            System.out.println("All places taken, remove student first");
        }
    }

    public void removeStudent(String name) {
        boolean isFound = false;
        for (int i = 0; i < this.students.length; i++) {

            if (this.students[i].getName().equals(name)) {
                this.students[i] = null;
                isFound = true;
            }
        }

        if (isFound) {
            System.out.println("Successfully removed student from the list");
        } else {
            System.out.println("Student not found");
        }
    }

    public Student findStudent(String name) {

        for (int i = 0; i < this.students.length; i++) {

            if (this.students[i].getName().equals(name)) {
                return this.students[i];
            }
        }

        return null;
    }

    public String toString() {
        String stringToReturn = "[\n";
        
        for (int i = 0; i < this.students.length; i++) {

            if (this.students[i] != null) {
                stringToReturn += this.students[i].toString() + "\n";
            }
        }

        stringToReturn += "]";
        return stringToReturn;
    }
}
