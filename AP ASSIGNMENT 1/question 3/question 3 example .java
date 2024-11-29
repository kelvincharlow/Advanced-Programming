import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(300);
        Calendar date = Calendar.getInstance();

        WithdrawalTransaction withdrawal1 = new WithdrawalTransaction(500, date);
        
        // Full withdrawal attempt (throws exception if insufficient funds)
        try {
            withdrawal1.apply(account);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }

        WithdrawalTransaction withdrawal2 = new WithdrawalTransaction(200, date);
        withdrawal2.apply(account, true); // Partial withdrawal with shortfall
    }
}
