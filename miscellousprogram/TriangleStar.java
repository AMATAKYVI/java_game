package miscellousprogram;

import java.util.Scanner;

public class TriangleStar {

    static Scanner console = new Scanner(System.in);

    public static void main(String[] args) {

        int numberOfLines;
        int counter = 1;

        System.out.println("Enter the number of lines for the triangle: ");
        numberOfLines = console.nextInt();
        System.out.println();

        while (counter <= numberOfLines) {
            printBlanks(numberOfLines - counter);
            printStars(2 * counter - 1);
            counter++;
        }
    }

    private static void printBlanks(int i) {
        int numberOfBlanks = 1;
        while (numberOfBlanks <= i) {
            System.out.print(" ");
            numberOfBlanks++;
        }
    }

    public static void printStars(int starsInLine) {
        int numberOfStars = 1;
        while (numberOfStars <= starsInLine) {
            System.out.print("*");
            numberOfStars++;
        }
        System.out.println();
    }
}
