public class Student {
    private String name;
    private int age;
    private double gpa;
    private String emailAddress;
    private String phoneNumber;
    
    public static int studentCount = 0;

    public static void main(String args[]) {
        Student student1 = new Student();
        Student student2 = new Student("John Doe", 20, 3.5, "john.doe@example.com", "204-555-1111");

        System.out.println(student1);
        System.out.println(student2);

        System.out.println(Student.getStudentCount());
    }

    public Student() {
        this.name = "Unknown";
        this.age = 0;
        this.gpa = 0.0;
        this.emailAddress = "";
        this.phoneNumber = "";

        this.studentCount++;
    }

    public Student(String name, int age, double gpa, String email, String phone) {
        this.setName(name);
        this.setAge(age);
        this.setGPA(gpa);
        this.setEmail(email);
        this.setPhone(phone);

        this.studentCount++;
    }

    public void setName(String name) {
        
        if (name == null || name.isBlank()) {
            this.name = "Unknown";
            System.out.println("Error: Student name cannot be null or empty");
        } else {
            this.name = name;
        }
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGPA(double gpa) {
        this.gpa = gpa;
    }

    public void setEmail(String email) {
        
        if (email.matches("[a-zA-Z0-9+_.-]+@\\w+\\.com")) {
            this.emailAddress = email;
        } else {
            System.out.println("Error: Email must be in the right format");
        }
    }

    public void setPhone(String phone) {

        if (phone.matches("\\d{3}-\\d{3}-\\d{4}")) {
            this.phoneNumber = phone;
        } else {
            System.out.println("Error: Phone number must be in the format xxx-xxx-xxxx");
        }
    }

    public String getName() {
        return this.name;
    }

    public static int getStudentCount() {
        return studentCount;
    }

    public String toString() {
        return String.format("Student{name=%s, age=%d, gpa=%.1f, email=%s, phone=%s}", this.name, this.age, this.gpa, this.emailAddress, this.phoneNumber);
    }
}

