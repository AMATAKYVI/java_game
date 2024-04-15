package miscellousprogram;

import javax.swing.JOptionPane;

public class MovieTicketSale {

    public static void main(String[] args) {
        String movieName;
        String inputStr;
        String outputStr;

        double adultTicketPrice;
        double childTicketPrice;

        int noOfAdultTicketSold;
        int noOfChildTicketSold;

        double percentDonation;
        double grossAmount;
        double amountDonated;
        double netSaleAmount;

        movieName = JOptionPane.showInputDialog("Enter the movie name: ");
        inputStr = JOptionPane.showInputDialog("Enter the price of an adult ticket: ");
        adultTicketPrice = Double.parseDouble(inputStr);
        inputStr = JOptionPane.showInputDialog("Enter the price of a child ticket: ");
        childTicketPrice = Double.parseDouble(inputStr);
        inputStr = JOptionPane.showInputDialog("Enter the number of adult tickets sold: ");
        noOfAdultTicketSold = Integer.parseInt(inputStr);
        inputStr = JOptionPane.showInputDialog("Enter the number of child tickets sold: ");
        noOfChildTicketSold = Integer.parseInt(inputStr);
        inputStr = JOptionPane.showInputDialog("Enter the percentage of the donation: ");
        percentDonation = Double.parseDouble(inputStr);

        grossAmount =
                adultTicketPrice * noOfAdultTicketSold + childTicketPrice * noOfChildTicketSold;
        amountDonated = grossAmount * percentDonation / 100;
        netSaleAmount = grossAmount - amountDonated;

        outputStr = "Movie Name: " + movieName + "\n" + "Number of Tickets Sold: "
                + (noOfAdultTicketSold + noOfChildTicketSold) + "\n" + "Gross Amount: $"
                + grossAmount + "\n" + "Percentage of Gross Amount Donated: " + percentDonation
                + "%\n" + "Amount Donated: $" + amountDonated + "\n" + "Net Sale Amount: $"
                + netSaleAmount;

        JOptionPane.showMessageDialog(null, outputStr, "Theater Sales Data",
                JOptionPane.INFORMATION_MESSAGE);

        System.exit(0);

    }
}
