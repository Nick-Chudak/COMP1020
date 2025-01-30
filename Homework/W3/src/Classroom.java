/**
 *
 * COMP 1020 SECTION A04
 * INSTRUCTOR    Pouya Aghahoseini
 * ASSIGNMENT    Homework W3
 * @author       Mykola Chudak, 8043157
 * @version      1/29/2025
 */


public class Classroom {
    
    String className;
    StudentList studentlist;
    
    public Classroom(String name, int capacity) {
        this.className = name;
        this.studentlist = new StudentList(capacity);

    }

    public void addStudent(Student student) {
        studentlist.addStudent(student);
    }

    public Classroom clone() {

        Classroom clonedClassroom = new Classroom(this.className, this.studentlist.capacity);

        for (int i = 0; i < studentlist.currentStudentCount; i++) {
            clonedClassroom.addStudent(new Student(studentlist.students[i]));
        }
        return clonedClassroom;
    }

    public String toString() {
        return "Class name: " + this.className + "\n" + studentlist.toString();
    }
}
