import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JFileChooser;

import java.util.*;
import java.io.*;

class ReadFile {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("./data.txt");
            Scanner sc = new Scanner(fr);

            FileWriter fw = new FileWriter("output.txt");
            PrintWriter pw = new PrintWriter(fw);

            // JFileChooser fileChooser = new JFileChooser();
            // int resultOfFileChooser = fileChooser.showOpenDialog(null);

            // if (resultOfFileChooser == JFileChooser.APPROVE_OPTION) {

            // }

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] items = line.split(" ");
                String result = calculate(line);
                pw.println(result);
            }

            sc.close();
            pw.close();
        }
        catch(FileNotFoundException fne) {
            System.out.println("File not found");
        }
        catch(IOException ioe) {
            System.out.println("Error reading/writing file");
        }
    }

    public static String calculate(String line){
        String[] terms = line.split(" "); // array of 3 strings
        int result;
        String message = "Not calcualted";
        switch (terms[0]){
            case "ADD":
                result = Integer.parseInt(terms[1]) + Integer.parseInt(terms[2]);
                message = "The sum of " + terms[1] + " and " + terms[2] + " is: " + result;
                break;
            
            case "MINUS":
                result = Integer.parseInt(terms[1]) - Integer.parseInt(terms[2]);
                message = "The difference of " + terms[1] + " and " + terms[2] + " is: " + result;
                break;

            case "POW":
                result = (int) Math.pow(Integer.parseInt(terms[1]), Integer.parseInt(terms[2]));
                message = "The result of " + terms[1] + " to the power of " + terms[2] + " is: " + result;
                break;

            default:
                break;
        }
        return message;
    }
}