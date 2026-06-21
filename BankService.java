import java.util.HashMap;

public class BankService {
    private final HashMap<Integer, BankAccount> accounts = new HashMap<>();

    // If account doesn't exist, create it automatically with zero balance
    public BankAccount getOrCreateAccount(int accountNumber) {
        return accounts.computeIfAbsent(accountNumber,
            accNum -> new BankAccount(accNum, "User-" + accNum, 0.0));
    }
}
