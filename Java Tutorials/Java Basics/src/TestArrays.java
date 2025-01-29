import java.util.Scanner;
import java.util.Arrays;

// public class App {
//     public static void main(String[] args) throws Exception {
//         // Scanner scanner = new Scanner(System.in);

//         // System.out.println("Name?");
//         // String name = scanner.nextLine();

//         // System.out.println("Name is " + name);

//         // scanner.close();

//         Scanner scanner = new Scanner(System.in);
//         System.out.println("Enter the operator");
        
//         String operation = scanner.nextLine();
//         Integer number1 = Integer.parseInt(scanner.nextLine());
//         Integer number2 = Integer.parseInt(scanner.nextLine());

//         if (operation.equals("sum")) {
//             System.out.printf("%f + %f = %f", number1, number2, number1 + number2);
//         } else {
//             System.out.printf("%s is not a supported operation", operation);   
//         }

//         scanner.close();
//     }
// }


// public class SwitchCase {
//     public static void main(String[] args) throws Exception {
//         Scanner scanner = new Scanner(System.in);

//         System.out.print("Enter the first number: ");
//         double number1 = scanner.nextDouble();
//         scanner.nextLine();

//         System.out.print("Enter the first number: ");
//         double number2 = scanner.nextDouble();
//         scanner.nextLine();

//         System.out.print("Enter operator: ");
//         String operation = scanner.nextLine();

//         switch (operation) {
//             case "sum":
//                 System.out.printf("%f + %f = %f", number1, number2, number1 + number2);
//                 break;
//             default: 
//                 System.out.printf("%s is not a supported operation", operation);
//         }

//         scanner.close();
//     }
// };

public class TestArrays {
    public static void main(String[] args) {
        char vowels[] = new char[5];
        char array2[] = {'a', 'b', 'd', 'c'};
        int numbers[] = {1, 2 , 3, 4, 5};
        int copyOfNumbers[] = numbers;
        int properCopyOfNumbers[] = Arrays.copyOf(numbers, numbers.length);


        int startIndex = 0;
        int endIndex = 4;
        // a e i o u
        vowels[0] = 'a';
        vowels[1] = 'e';
        vowels[2] = 'i';
        vowels[3] = 'o';
        vowels[4] = 'u';
        
        Arrays.sort(array2, startIndex, endIndex);
        Arrays.fill(vowels, 'x');
        Arrays.fill(copyOfNumbers, 0);

        System.out.println(Arrays.toString(vowels));
        System.out.println(Arrays.toString(array2));
        System.out.println(Arrays.toString(numbers));
        System.out.println(Arrays.toString(copyOfNumbers));
        System.out.println(Arrays.toString(properCopyOfNumbers));

    }
}

class forLoop {
    public static void main(String[] args) {
        int numbers[] = {1, 2, 4, 4, 5, 6, 7, 8, 9, 10};
        int sum = 0;


        for(int number = 1; number <= 10; number ++) {
            System.out.println(number);
        };

        for(int index = 1; index < numbers.length; index++ ) {
            System.out.println(numbers[index]);
            sum += numbers[index];
        }

        System.out.println(sum);
    }
}