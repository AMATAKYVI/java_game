package miscellousprogram;

import java.util.Scanner;

public class Conversion {
    static Scanner console = new Scanner(System.in);

    static final double CENTIMETERS_PER_INCH = 2.54;
    static final int INCHES_PER_FOOT = 12;

    public static void main(String[] args) {
        int feet;
        int inches;
        int totalInches;

        double centimeters;

        System.out.println("Enter feet: ");
        feet = console.nextInt();
        System.out.println();
        System.out.println("Enter inches: ");
        inches = console.nextInt();
        System.out.println();
        System.out.println("The numbers you entered are: " + feet + " for feet and " + inches
                + " for inches. ");
        totalInches = feet * INCHES_PER_FOOT + inches;
        System.out.println();
        System.out.println("The total number of inches = " + totalInches);
        centimeters = totalInches * CENTIMETERS_PER_INCH;
        System.out.println();
        System.out.println("The number of centimeters = " + centimeters);

    }

}
