import java.util.Scanner;
import java.util.ArrayList;

public class Lab6Ex3 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String line;
    String[] tokens;
    int number;
    ArrayList<Integer> numbers = new ArrayList<>();
    
    System.out.println("Enter some values separated by commas:");
    
    line = "";
    while (!line.equals("quit")) {
      line = in.nextLine();
      tokens = line.split(",");
      for (String token : tokens) {
        System.out.print("You entered: '" + token + "' ");
        try {
          number = Integer.parseInt(token);
          System.out.println("which is the integer " + number);
          // Step 1: add number to an array list
          numbers.add(number);
        } catch (NumberFormatException nfe) {
          System.out.println("which is not an integer.");
        }
      }
    }
    
    double average = getAverage(numbers);
    ArrayList<Integer> clonedArray = clone(numbers);
    
    removeBelowAverage(numbers, average);

    System.out.println("The average is: " + average);
    System.out.println("Cloned: " + clonedArray);

    System.out.println("Original: " +  numbers);
    System.out.println("*** End of program ***");
  }

  // Steps 2 and beyond:
  public static double getAverage(ArrayList<Integer> numbers) {
    double total = 0;

    for (int i = 0; i < numbers.size(); i++) {
      total += numbers.get(i);
    }

    return total / numbers.size();
  }

  public static ArrayList<Integer> clone(ArrayList<Integer> numbers) {
    ArrayList<Integer> result = new ArrayList<Integer>();

    for (int i = 0; i < numbers.size(); i++) {
      result.add(numbers.get(i));
    }
    
    return result;
  }

  public static void removeBelowAverage(ArrayList<Integer> numbers, double average) {

    for (int i = 0; i < numbers.size(); ) {
      if (numbers.get(i) < average) {
          numbers.remove(i);
      } else {
          i++;
      }
    }
  }


}