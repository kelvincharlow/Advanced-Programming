package Lecture4_interfaces_abstract_classes;

import org.jetbrains.annotations.NotNull;
import java.util.Calendar;

public class BaseTransaction implements TransactionInterface {
    private final double amount;
    private final Calendar date;
    private final String transactionID;

    // Constructor
    public BaseTransaction(double amount, @NotNull Calendar date) {
        this.amount = amount;
        this.date = (Calendar) date.clone(); // Defensive copy of date
        int uniq = (int) (Math.random() * 10000);
        this.transactionID = date.getTimeInMillis() + "-" + uniq;
    }

    // Method to get the transaction amount
    @Override
    public double getAmount() {
        return amount;
    }

    // Method to get the transaction date
    @Override
    public Calendar getDate() {
        return (Calendar) date.clone();
    }

    // Method to get a unique transaction ID
    @Override
    public String getTransactionID() {
        return transactionID;
    }

    // Method to print transaction details
    public void printTransactionDetails() {
        System.out.println("Transaction ID: " + transactionID);
        System.out.println("Amount: " + amount);
        System.out.println("Date: " + date.getTime());
    }

    // Apply method - default implementation
    public void apply(BankAccount ba) {
        System.out.println("BaseTransaction applied. No change in balance.");
    }
}
