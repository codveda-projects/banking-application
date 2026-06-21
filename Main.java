import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            BankService service = new BankService();
            boolean systemRunning = true;

            while (systemRunning) {
                // New user login
                System.out.print("\nEnter your Account Number to log in: ");
                int accNum = scanner.nextInt();
                BankAccount account = service.getOrCreateAccount(accNum);

                boolean userSession = true;
                while (userSession) {
                    System.out.println("\n=== Simple Banking Application ===");
                    System.out.println("Account Number: " + accNum);
                    System.out.println("1. Deposit");
                    System.out.println("2. Withdraw");
                    System.out.println("3. Check Balance");
                    System.out.println("4. Logout");
                    System.out.println("5. Exit System");
                    System.out.print("Choose an option: ");

                    int choice = scanner.nextInt();

                    switch (choice) {
                        case 1 -> {
                            System.out.print("Enter deposit amount: ");
                            double depositAmount = scanner.nextDouble();
                            account.deposit(depositAmount);
                        }
                        case 2 -> {
                            System.out.print("Enter withdrawal amount: ");
                            double withdrawAmount = scanner.nextDouble();
                            account.withdraw(withdrawAmount);
                        }
                        case 3 -> account.checkBalance();
                        case 4 -> {
                            userSession = false;
                            System.out.println("Logged out of Account " + accNum);
                        }
                        case 5 -> {
                            userSession = false;
                            systemRunning = false;
                            System.out.println("Exiting system. Goodbye!");
                        }
                        default -> System.out.println("Invalid choice. Try again.");
                    }
                }
            }
        }
    }
}
