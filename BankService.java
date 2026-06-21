import java.util.HashMap;

public class BankService {
    private final HashMap<Integer, BankAccount> accounts = new HashMap<>();

    public void addAccount(BankAccount account) {
        accounts.put(account.getAccountNumber(), account);
        System.out.println("Account created successfully!");
    }

    public BankAccount getAccount(int accountNumber) {
        return accounts.get(accountNumber);
    }
}
