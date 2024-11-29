import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        // Create a BankAccount with an initial balance of 1000
        BankAccount account = new BankAccount(1000);
        Calendar date = Calendar.getInstance();

        // Create DepositTransaction and WithdrawalTransaction objects
        DepositTransaction deposit = new DepositTransaction(300, date);
        WithdrawalTransaction withdrawal = new WithdrawalTransaction(500, date);

        // Apply deposit and withdrawal using subclass objects
        System.out.println("Applying DepositTransaction directly:");
        deposit.apply(account);
        deposit.printTransactionDetails();

        System.out.println("\nApplying WithdrawalTransaction directly:");
        try {
            withdrawal.apply(account);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }
        withdrawal.printTransactionDetails();

        // Demonstrate polymorphism by casting to BaseTransaction
        System.out.println("\nCasting transactions to BaseTransaction and applying:");

        BaseTransaction baseDeposit = (BaseTransaction) deposit;
        BaseTransaction baseWithdrawal = (BaseTransaction) withdrawal;

        // Apply using the base type reference
        System.out.println("\nApplying DepositTransaction via BaseTransaction reference:");
        baseDeposit.apply(account);

        System.out.println("\nApplying WithdrawalTransaction via BaseTransaction reference:");
        try {
            baseWithdrawal.apply(account);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }
    }
}
