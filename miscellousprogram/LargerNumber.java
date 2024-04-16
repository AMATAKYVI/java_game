package miscellousprogram;

import static java.lang.Math.random;
import java.util.Scanner;

public class LargerNumber {

    static Scanner console = new Scanner(System.in);

    public static void main(String[] args) {

        double num1;
        double num2;

        System.out.println("Enter the first number: ");
        num1 = console.nextDouble();
        System.out.println("Enter the second number: ");
        num2 = console.nextDouble();

        System.out.println("The larger number is: " + larger(num1, num2));
        System.out.println("The secret number is: " + secretEncrypt(5));
        System.out.println("The function return statement is: " + funcReturnStatements(5));
        System.out.println("The dice roll is: " + rollDice(6));
    }

    public static double larger(double x, double y) {
        if (x > y) {
            return x;
        } else {
            return y;
        }
    }

    public static double secretEncrypt(int x) {
        return x * 5 + Math.random() * 10;
    }

    public static double funcReturnStatements(int z) {
        if (z > 0) {
            return 1;
        } else if (z < 0) {
            return -1;
        } else {
            return 0;
        }
    }

    public static int rollDice(int num) {
        return (int) (Math.random() * num) + 1;
    }
}
