package miscellousprogram;

import javax.swing.*;

public class TempConversion extends JFrame {
    private static final int WIDTH = 500;
    private static final int HEIGHT = 50;

    private static final double FTOC = 5.0 / 9.0;
    private static final double CTOF = 9.0 / 5.0;

    private static final int OFFSET = 32;

    // contructor
    public TempConversion() {
        setTitle("Temparature Conversion");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        TempConversion tempConversion = new TempConversion();
        String inputString;
        String outputString;

        double fahrenheit;
        double celsius;

        inputString = JOptionPane.showInputDialog("Enter the temperature in Fahrenheit: ");
        fahrenheit = Double.parseDouble(inputString);

        celsius = FTOC * (fahrenheit - OFFSET);
        outputString = "The temperature in Fahrenheit is: " + fahrenheit + "\n"
                + "The temperature in Celsius is: " + celsius;
        JOptionPane.showMessageDialog(null, outputString, "Temperature Conversion",
                JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}
