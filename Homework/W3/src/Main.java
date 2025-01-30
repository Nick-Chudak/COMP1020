/**
 *
 * COMP 1020 SECTION A04
 * INSTRUCTOR    Pouya Aghahoseini
 * ASSIGNMENT    Homework W3
 * @author       Mykola Chudak, 8043157
 * @version      1/29/2025
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Test default constructor
        Student defaultStudent = new Student();
        System.out.println("Default Constructor:");
        System.out.println(defaultStudent);
        System.out.println();

        // Test parameterized constructor
        System.out.println("Enter details for parameterized constructor (name, age, gpa, email, phone):");
        String name = scanner.nextLine();
        int age = scanner.nextInt();
        double gpa = scanner.nextDouble();
        scanner.nextLine(); // consume newline
        String email = scanner.nextLine();
        String phone = scanner.nextLine();
        Student paramStudent = new Student(name, age, gpa, email, phone);
        System.out.println("Parameterized Constructor:");
        System.out.println(paramStudent);
        System.out.println();

        // Test copy constructor
        Student copyStudent = new Student(paramStudent);
        System.out.println("Copy Constructor:");
        System.out.println(copyStudent);
        System.out.println();

        // Test email validation
        System.out.println("Enter an email to validate:");
        String testEmail = scanner.nextLine();
        boolean isEmailValid = paramStudent.setEmailAddress(testEmail);
        System.out.println("Email Validation:");
        System.out.println("Email (" + testEmail + ") is valid: " + isEmailValid);
        System.out.println();

        // Test phone number validation
        System.out.println("Enter a phone number to validate:");
        String testPhone = scanner.nextLine();
        boolean isPhoneValid = paramStudent.setPhoneNumber(testPhone);
        System.out.println("Phone Number Validation:");
        System.out.println("Phone number (" + testPhone + ") is valid: " + isPhoneValid);
        System.out.println();

        // Test static method getStudentCount
        System.out.println("Total Students Created: " + Student.getStudentCount());
    }
}