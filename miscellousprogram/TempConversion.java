package miscellousprogram;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TempConversion extends JFrame {
    private JLabel celsiusLabel; // Corrected variable name
    private JLabel fahrenheitLabel;
    private JTextField celsiusTextField; // Corrected variable name
    private JTextField fahrenheitTextField;

    private CelsHandler celsiusHandler; // Corrected class name
    private FahrHandler fahrenheitHandler;

    private static final int WIDTH = 500;
    private static final int HEIGHT = 50;

    private static final double FTOC = 5.0 / 9.0;
    private static final double CTOF = 9.0 / 5.0;

    private static final int OFFSET = 32;

    // Constructor
    public TempConversion() {
        setTitle("Temperature Conversion");
        Container c = getContentPane(); // Corrected method name
        c.setLayout(new GridLayout(1, 4));
        celsiusLabel = new JLabel("Enter temperature in Celsius: ", SwingConstants.RIGHT);
        fahrenheitLabel = new JLabel("Enter temperature in Fahrenheit: ", SwingConstants.RIGHT);

        celsiusTextField = new JTextField(7);
        fahrenheitTextField = new JTextField(7);

        c.add(celsiusLabel);
        c.add(celsiusTextField);
        c.add(fahrenheitLabel);
        c.add(fahrenheitTextField);

        celsiusHandler = new CelsHandler();
        fahrenheitHandler = new FahrHandler();

        celsiusTextField.addActionListener(celsiusHandler);
        fahrenheitTextField.addActionListener(fahrenheitHandler);

        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    private class CelsHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            double celsius, fahrenheit;
            celsius = Double.parseDouble(celsiusTextField.getText());
            fahrenheit = CTOF * celsius + OFFSET;
            fahrenheitTextField.setText(String.format("%.2f", fahrenheit));
        }
    }

    private class FahrHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            double celsius, fahrenheit;
            fahrenheit = Double.parseDouble(fahrenheitTextField.getText());
            celsius = FTOC * (fahrenheit - OFFSET);
            celsiusTextField.setText(String.format("%.2f", celsius));
        }
    }

    public static void main(String[] args) {
        TempConversion tempConversion = new TempConversion();
    }
}
