package com.mycompany.prac3java;

// Custom exception for wrong PIN
class InvalidPinException extends Exception {
    public InvalidPinException(String message) {
        super(message);
    }
}

// Custom exception for too many failed attempts
class AccountLockedException extends Exception {
    public AccountLockedException(String message) {
        super(message);
    }
}

// ATM class
class ATM {
    private final int correctPin = 1234;
    private int attempts = 0;
    private static final int MAX_ATTEMPTS = 3;

    public void enterPin(int pin) throws InvalidPinException, AccountLockedException {
        if (attempts >= MAX_ATTEMPTS) {
            throw new AccountLockedException("Account locked due to too many failed attempts.");
        }
        if (pin != correctPin) {
            attempts++;
            throw new InvalidPinException("Incorrect PIN. Attempt " + attempts + " of " + MAX_ATTEMPTS + ".");
        }
        System.out.println("PIN accepted. Access granted.");
        attempts = 0; // reset on success
    }
}

// Renamed from ATMExceptionDemo to PRAC3CJAVA to match the filename
public class PRAC3CJAVA {
    public static void main(String[] args) {
        ATM atm = new ATM();
        int[] pinAttempts = {1111, 2222, 3333, 4444}; // all wrong, 4th should trigger lock

        for (int pin : pinAttempts) {
            try {
                atm.enterPin(pin);
            } catch (InvalidPinException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (AccountLockedException e) {
                System.out.println("Error: " + e.getMessage());
                break; // stop trying once locked
            }
        }
    }
}