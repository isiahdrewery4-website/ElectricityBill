import java.util.*;
import java.io.*;

public class ElectricityBill
{
    static Scanner console = new Scanner(System.in);

    public static void main(String[] args) throws IOException
    {
        String customerName;
        String accountNumber;
        String paymentStatus;

        double kWh;
        double electricityCharge;
        double lateFee;
        double totalAmount;

        boolean overdue;

        System.out.print("Enter customer name: ");
        customerName = console.nextLine();

        System.out.print("Enter account number: ");
        accountNumber = console.nextLine();

        System.out.print("Enter electricity usage in kWh: ");
        kWh = console.nextDouble();
        console.nextLine();

        System.out.print("Is payment overdue? (yes/no): ");
        paymentStatus = console.nextLine();

        overdue = paymentStatus.equalsIgnoreCase("yes");

        // Calculate electricity charge
        if (kWh <= 100)
            electricityCharge = kWh * 0.12;
        else if (kWh <= 300)
            electricityCharge = 100 * 0.12
                              + (kWh - 100) * 0.15;
        else
            electricityCharge = 100 * 0.12
                              + 200 * 0.15
                              + (kWh - 300) * 0.18;

        // Calculate late-payment fee
        if (overdue)
            lateFee = 25.00;
        else
            lateFee = 0.00;

        // Calculate total amount
        totalAmount = electricityCharge + lateFee;

        // Display the bill
        System.out.println();
        System.out.println("========== ELECTRICITY BILL ==========");
        System.out.println("Customer Name: " + customerName);
        System.out.println("Account Number: " + accountNumber);
        System.out.printf("Electricity Usage: %.2f kWh%n", kWh);
        System.out.printf("Electricity Charge: $%.2f%n",
                          electricityCharge);
        System.out.printf("Late-Payment Fee: $%.2f%n", lateFee);
        System.out.printf("Total Amount Due: $%.2f%n", totalAmount);
        System.out.println("======================================");

        // Save the bill to the output file
        PrintWriter outFile = new PrintWriter(
                              new FileWriter("electricity_bill.txt"));

        outFile.println("========== ELECTRICITY BILL ==========");
        outFile.println("Customer Name: " + customerName);
        outFile.println("Account Number: " + accountNumber);
        outFile.printf("Electricity Usage: %.2f kWh%n", kWh);
        outFile.printf("Electricity Charge: $%.2f%n",
                       electricityCharge);
        outFile.printf("Late-Payment Fee: $%.2f%n", lateFee);
        outFile.printf("Total Amount Due: $%.2f%n", totalAmount);
        outFile.println("======================================");

        outFile.close();

        System.out.println();
        System.out.println("Bill saved to electricity_bill.txt");
    }
}
