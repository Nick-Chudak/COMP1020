import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private static Menu menu;

    private Menu() {

    }

    public static Menu getInstance() {

        if (menu == null) {
            menu = new Menu();
        }
        return menu;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public void displayMenu() {

        System.out.println("Welcome to the Pokémon Game!");
        System.out.println("1. Play Game");
        System.out.println("2. Get Pokémon Stats");
        System.out.println("3. Get Player Stats");
        System.out.println("4. Get Type Stats");
        System.out.println("5. Get Move Stats");
        System.out.println("6. Exit");
        
    }

    public void runMenu() {

        this.displayMenu();
        int choice = this.getValidIntegerChoice(6);

        switch (choice) {
            case 1:
                System.out.println("Starting game...");
                break;
            case 2:
                System.out.println("Retrieving Pokémon stats...");
                break;
            case 3:
                System.out.println("Retrieving player stats...");
                break;
            case 4:
                System.out.println("Retrieving type stats...");
                break;
            case 5:
                System.out.println("Retrieving move stats...");
                break;
            case 6:
                System.out.println("Exiting game. Goodbye!");
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    public int getValidIntegerChoice(int max) {
        int choice = 0;

        while (true) {
            System.out.print("Enter the choice (1-" + max + "): ");

            if (scanner.hasNextInt()) {
                choice = this.scanner.nextInt();
                this.scanner.nextLine();

                if (choice >= 1 && choice <= max) {
                    return choice;
                } else {
                    System.out.println("Invalid choice. Please enter a number between 1 and " + max + ".");
                }

            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); 
            }
        }
    }
    
    public String getValidStringInput() {

        while (true) {

            System.out.print("Enter a valid string (letters only, no spaces): ");
            String input = scanner.next();
            if (input.matches("[a-zA-Z]+")) {
                return input;
            } else {
                System.out.println("Invalid input. Only letters are allowed without spaces.");
            }
        }
    }

    }
}
