package Lecture4_interfaces_abstract_classes;

import org.jetbrains.annotations.NotNull;
import java.util.Calendar;

public class WithdrawalTransaction extends BaseTransaction {
    private boolean isApplied = false; // Track if the transaction has been applied

    public WithdrawalTransaction(double amount, @NotNull Calendar date) {
        super(amount, date);
    }

    @Override
    public void apply(BankAccount ba) {
        double curr_balance = ba.getBalance();
        if (curr_balance >= getAmount()) {
            ba.setBalance(curr_balance - getAmount());
            isApplied = true;
            System.out.println("Withdrawal of " + getAmount() + " applied. New balance: " + ba.getBalance());
        } else {
            System.out.println("Insufficient funds. Withdrawal denied.");
        }
    }

    // Method to reverse the withdrawal transaction
    public boolean reverse(BankAccount ba) {
        if (isApplied) {
            ba.setBalance(ba.getBalance() + getAmount());
            isApplied = false; // Reset status after reversal
            System.out.println("Withdrawal of " + getAmount() + " reversed. New balance: " + ba.getBalance());
            return true;
        } else {
            System.out.println("Withdrawal cannot be reversed as it was not applied.");
            return false;
        }
    }

    @Override
    public void printTransactionDetails() {
        System.out.println("Withdrawal Transaction:");
        super.printTransactionDetails();
    }
}
