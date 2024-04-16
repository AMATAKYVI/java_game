package miscellousprogram;

import java.util.Scanner;

public class TestClockProg {

    static Scanner console = new Scanner(System.in);

    public static void main(String[] args) {

        Clock myClock = new Clock(5, 4, 30);
        System.out.println("The time is: " + myClock);

        System.out.println("Enter the hours: ");
        int hours = console.nextInt();
        System.out.println("Enter the minutes: ");
        int minutes = console.nextInt();
        System.out.println("Enter the seconds: ");
        int seconds = console.nextInt();

        myClock.setTime(hours, minutes, seconds);
        System.out.println("The time is: " + myClock);

        myClock.incrementSeconds();
        System.out.println("The time is: " + myClock);

        myClock.incrementMinutes();
        System.out.println("The time is: " + myClock);

        myClock.incrementHours();
        System.out.println("The time is: " + myClock);


    }


}
