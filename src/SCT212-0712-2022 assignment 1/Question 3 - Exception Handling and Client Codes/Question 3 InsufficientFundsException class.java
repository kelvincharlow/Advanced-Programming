package Lecture4_interfaces_abstract_classes;

/**
 * Custom exception to handle insufficient funds.
 */
public class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}
