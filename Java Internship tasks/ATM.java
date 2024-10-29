import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        if (initialBalance > 0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0.0;
        }
    }

    public double checkBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrawn: $" + amount);
            return true;
        } else if (amount > balance) {
            System.out.println("Insufficient balance!");
            return false;
        } else {
            System.out.println("Invalid withdrawal amount!");
            return false;
        }
    }
}


public class ATM {
    private BankAccount account;
    private Scanner scanner;

    
    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    
    public void displayMenu() {
        int option;
        do {
            System.out.println("\n------------ Welcome to the ATM ------------");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 4);
    }

    
    public void checkBalance() {
        System.out.println("Your current balance is: $" + account.checkBalance());
    }

    
    public void deposit() {
        System.out.print("Enter deposit amount: ");
        double amount = scanner.nextDouble();
        account.deposit(amount);
    }

    
    public void withdraw() {
        System.out.print("Enter withdrawal amount: ");
        double amount = scanner.nextDouble();
        if (account.withdraw(amount)) {
            System.out.println("Please collect your cash.");
        }
    }

    
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000.00);
        ATM atm = new ATM(userAccount);
        atm.displayMenu();
    }
}
