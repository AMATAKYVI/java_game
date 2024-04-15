package miscellousprogram;

import java.util.Scanner;

public class ClassifyNumber {

    static Scanner console = new Scanner(System.in);
    static final int N = 20;

    public static void main(String[] args) {
        int counter;
        int number;

        int zeros = 0;
        int odds = 0;
        int evens = 0;

        System.out.println("Please enter " + N + " integers, positive, " + " negative, or zeros.");
        for (counter = 1; counter < N; counter++) {
            number = console.nextInt();
            System.out.println(number + " ");
            switch (number % 2) {
                case 0:
                    evens++;
                    break;
                case 1:
                case -1:
                    odds++;
                    break;
                default:
                    break;
            }
            System.out.println();
            System.out.println(
                    "There are " + evens + " evens, " + "which also includes " + zeros + " zeros");
            System.out.println("The number of odds is: " + odds);


        }

    }

}
