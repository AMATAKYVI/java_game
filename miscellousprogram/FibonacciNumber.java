package miscellousprogram;

import javax.swing.JOptionPane;

public class FibonacciNumber {

    public static void main(String[] args) {
        String inputString;
        String outputString;

        int previous1;
        int previous2;
        int current = 0;
        int counter;
        int nthFibonacci;

        inputString = JOptionPane.showInputDialog("Enter the nth Fibonacci number: ");
        previous1 = Integer.parseInt(inputString);

        inputString = JOptionPane.showInputDialog("Enter the nth Fibonacci number: ");
        previous2 = Integer.parseInt(inputString);

        outputString = "The first two Fibonacci numbers are: " + previous1 + " and " + previous2;

        inputString = JOptionPane.showInputDialog("Enter the nth Fibonacci number: ");
        nthFibonacci = Integer.parseInt(inputString);

        if (nthFibonacci == 1) {
            current = previous1;
        } else if (nthFibonacci == 2) {
            current = previous2;
        } else {
            for (counter = 3; counter <= nthFibonacci; counter++) {
                current = previous1 + previous2;
                previous1 = previous2;
                previous2 = current;
            }
        }

        outputString =
                outputString + "\nThe " + nthFibonacci + "th Fibonacci number is: " + current;
        JOptionPane.showMessageDialog(null, outputString, "Fibonacci Number",
                JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

}
