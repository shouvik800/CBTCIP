import java.util.Scanner;

public class ATMInterface {
    private int userId;
    private int userPin;
    private double balance;

    public ATMInterface(int userId, int userPin, double balance) {
        this.userId = userId;
        this.userPin = userPin;
        this.balance = balance;
    }

    public void displayMenu() {
        System.out.println("Welcome to the ATM interface");
        System.out.println("1. Transaction History");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Transfer");
        System.out.println("5. Exit");
    }

    public void performTransaction(int choice) {
        switch (choice) {
            case 1:
                displayTransactionHistory();
                break;
            case 2:
                withdraw();
                break;
            case 3:
                deposit();
                break;
            case 4:
                transfer();
                break;
            case 5:
                System.out.println("Thank you for using the ATM. Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    public void displayTransactionHistory() {
        System.out.println("Transaction History:");
        // Implement code to display transaction history here
    }

    public void withdraw() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();

        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. Current balance: " + balance);
        } else {
            System.out.println("Insufficient funds. Withdrawal failed.");
        }
    }

    public void deposit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();

        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. Current balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void transfer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the recipient's user ID: ");
        int recipientId = scanner.nextInt();
        System.out.print("Enter the amount to transfer: ");
        double amount = scanner.nextDouble();

        if (amount > 0 && amount <= balance) {
            // Implement code to perform the transfer here
            System.out.println("Transfer successful. Current balance: " + balance);
        } else {
            System.out.println("Invalid transfer or insufficient funds.");
        }
    }

    public static void main(String[] args) {
        ATMInterface atm = new ATMInterface(12345, 1234, 1000.0); // Replace with your user ID, PIN, and initial balance
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter User ID: ");
        int enteredUserId = scanner.nextInt();
        System.out.print("Enter PIN: ");
        int enteredPin = scanner.nextInt();

        if (enteredUserId == atm.userId && enteredPin == atm.userPin) {
            System.out.println("Authentication successful. Welcome!");
            while (true) {
                atm.displayMenu();
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                atm.performTransaction(choice);
            }
        } else {
            System.out.println("Authentication failed. Goodbye!");
        }
    }
}