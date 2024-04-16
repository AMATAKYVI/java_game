package miscellousprogram;

import java.util.Scanner;

public class Pool {
    static Scanner console = new Scanner(System.in);
    static final double GALLONS_IN_A_CUBIC_FEET = 7.48;

    public static void main(String[] args) {

        double length, width, depth;
        double fillRate;
        int fillTime;

        System.out.println("Enter the length, width, and the depth of the pool, (in feet): ");

        length = console.nextDouble();
        width = console.nextDouble();
        depth = console.nextDouble();
        System.out.println();
        System.out.println("Enter the fill rate of the pool, (in gallons per minute): ");
        fillRate = console.nextDouble();
        System.out.println();
        fillTime = (int) (length * width * depth * GALLONS_IN_A_CUBIC_FEET / fillRate);
        int fillTimeInMinutes = (int) (length * width * depth * GALLONS_IN_A_CUBIC_FEET / fillRate);
        int days = fillTimeInMinutes / (24 * 60); // Convert minutes to days
        int remainingMinutes = fillTimeInMinutes % (24 * 60); // Remaining minutes after converting
                                                              // to days
        int hours = remainingMinutes / 60; // Convert remaining minutes to hours
        int minutes = remainingMinutes % 60;
        System.out.println(
                "Fill time: " + days + " days, " + hours + " hours, " + minutes + " minutes");

    }

}
