package Lecture4_interfaces_abstract_classes;

import org.jetbrains.annotations.NotNull;
import java.util.Calendar;

public class DepositTransaction extends BaseTransaction {

    public DepositTransaction(double amount, @NotNull Calendar date) {
        super(amount, date);
    }

    @Override
    public void apply(BankAccount ba) {
        double curr_balance = ba.getBalance();
        ba.setBalance(curr_balance + getAmount());
        System.out.println("Deposit of " + getAmount() + " applied. New balance: " + ba.getBalance());
    }

    @Override
    public void printTransactionDetails() {
        System.out.println("Deposit Transaction:");
        super.printTransactionDetails();
    }
}
