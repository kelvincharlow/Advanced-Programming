import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(500);
        Calendar date = Calendar.getInstance();

        WithdrawalTransaction withdrawal = new WithdrawalTransaction(100, date);
        withdrawal.apply(account);  // Deducts 100
        withdrawal.printTransactionDetails();

        // Reverse the withdrawal
        withdrawal.reverse(account); // Adds back 100

        DepositTransaction deposit = new DepositTransaction(200, date);
        deposit.apply(account);  // Adds 200
        deposit.printTransactionDetails();

        // Attempt to reverse deposit (not allowed, no method available)
        // deposit.reverse(account); // This would result in a compile error
    }
}
