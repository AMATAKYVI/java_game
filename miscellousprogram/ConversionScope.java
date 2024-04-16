package miscellousprogram;

import java.util.Scanner;

public class ConversionScope {

    static Scanner console = new Scanner(System.in);
    static final double CONVERSION = 2.53;

    public static void main(String[] args) {
        int inches;
        int centimeters;
        int choice;

        do {
            showChoices();
            choice = console.nextInt();
            if (choice == 1) {
                System.out.println("Enter the number of inches: ");
                inches = console.nextInt();
                centimeters = (int) (inches * CONVERSION);
                System.out.println(inches + " inches is equal to " + centimeters + " centimeters.");
            } else if (choice == 2) {
                System.out.println("Enter the number of centimeters: ");
                centimeters = console.nextInt();
                inches = (int) (centimeters / CONVERSION);
                System.out.println(centimeters + " centimeters is equal to " + inches + " inches.");
            } else if (choice == 3) {
                System.out.println("Goodbye!");
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);
    }

    private static void showChoices() {
        System.out.println("1. Convert inches to centimeters");
        System.out.println("2. Convert centimeters to inches");
        System.out.println("3. Quit");
        System.out.println("Enter your choice: ");
    }
}
