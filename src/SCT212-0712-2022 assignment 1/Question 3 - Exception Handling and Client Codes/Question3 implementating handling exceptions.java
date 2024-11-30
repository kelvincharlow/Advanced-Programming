package Lecture4_interfaces_abstract_classes;

import org.jetbrains.annotations.NotNull;
import java.util.Calendar;

public class WithdrawalTransaction extends BaseTransaction {

    public WithdrawalTransaction(double amount, @NotNull Calendar date) {
        super(amount, date);
    }

    // Original apply method using exception handling
    @Override
    public void apply(BankAccount ba) throws InsufficientFundsException {
        double curr_balance = ba.getBalance();
        if (curr_balance >= getAmount()) {
            ba.setBalance(curr_balance - getAmount());
            System.out.println("Withdrawal of " + getAmount() + " applied. New balance: " + ba.getBalance());
        } else {
            throw new InsufficientFundsException("Insufficient funds for withdrawal. Available: " + curr_balance);
        }
    }

    // Overloaded apply method with partial withdrawal and exception handling
    public void apply(BankAccount ba, boolean allowPartial) {
        double curr_balance = ba.getBalance();
        double amountToWithdraw = getAmount();
        double shortfall = amountToWithdraw - curr_balance;

        try {
            if (curr_balance > 0 && curr_balance < amountToWithdraw && allowPartial) {
                System.out.println("Partial withdrawal of " + curr_balance + " applied.");
                ba.setBalance(0);
                System.out.println("Shortfall of " + shortfall + " recorded.");
            } else if (curr_balance >= amountToWithdraw) {
                ba.setBalance(curr_balance - amountToWithdraw);
                System.out.println("Full withdrawal of " + amountToWithdraw + " applied.");
            } else {
                throw new InsufficientFundsException("Insufficient funds. Cannot process withdrawal.");
            }
        } catch (InsufficientFundsException e) {
            System.out.println("Exception caught: " + e.getMessage());
        } finally {
            System.out.println("Transaction attempt complete.");
        }
    }

    @Override
    public void printTransactionDetails() {
        System.out.println("Withdrawal Transaction:");
        super.printTransactionDetails();
    }
}
