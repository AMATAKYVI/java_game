package miscellousprogram;

// programming is dynamic there is not right one way to do things
// ideally learn and find your own way to do things
// while it is best practice to follow rules
// but still ideally it is not the best
public class Clock {

    static int hours;
    static int minutes;
    static int seconds;

    public Clock() {
        hours = 0;
        minutes = 0;
        seconds = 0;
    }

    public Clock(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public void tick() {
        seconds++;
        if (seconds == 60) {
            seconds = 0;
            minutes++;
            if (minutes == 60) {
                minutes = 0;
                hours++;
                if (hours == 24) {
                    hours = 0;
                }
            }
        }
    }

    public void display() {
        System.out.println(hours + ":" + minutes + ":" + seconds);
    }

    public void setTime(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public void getHours() {
        System.out.println("Hours: " + hours);
    }

    public void getMinutes() {
        System.out.println("Minutes: " + minutes);
    }

    public void getSeconds() {
        System.out.println("Seconds: " + seconds);
    }

    public Clock getCopy() {
        return new Clock(hours, minutes, seconds);
    }

    public void incrementSeconds() {

        seconds++;
        if (seconds == 60) {
            seconds = 0;
            minutes++;
            if (minutes == 60) {
                minutes = 0;
                hours++;
                if (hours == 24) {
                    hours = 0;
                }
            }
        }
    }

    public void incrementMinutes() {

        minutes++;
        if (minutes == 60) {
            minutes = 0;
            hours++;
            if (hours == 24) {
                hours = 0;
            }
        }
    }

    public void incrementHours() {
        hours++;
        if (hours == 24) {
            hours = 0;
        }
    }

    public String toString() {
        return hours + ":" + minutes + ":" + seconds;
    }
}
