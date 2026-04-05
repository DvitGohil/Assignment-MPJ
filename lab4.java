import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// Custom Exception for low deposit
class LowDepositException extends Exception {
    public LowDepositException(String message) {
        super(message);
    }
}

class BankSystem {

    Scanner input = new Scanner(System.in);

    // Method to open a new account
    public void openAccount() {
        try {
            System.out.print("Enter Account Number (100-999): ");
            int accNo = input.nextInt();

            if (accNo < 100 || accNo > 999) {
                throw new Exception("Account number must be between 100 and 999");
            }

            System.out.print("Enter Account Holder Name: ");
            String name = input.next();

            System.out.print("Enter Initial Deposit: ");
            double deposit = input.nextDouble();

            if (deposit < 500) {
                throw new LowDepositException("Minimum deposit required is 500");
            }

            FileWriter writer = new FileWriter("accounts.txt", true);
            writer.write(accNo + " " + name + " " + deposit + "\n");
            writer.close();

            System.out.println("Account successfully opened!");

        } catch (LowDepositException e) {
            System.out.println("Deposit Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("File Error occurred.");
        } catch (Exception e) {
            System.out.println("Input Error: " + e.getMessage());
        }
    }

    // Method to withdraw money
    public void withdrawMoney() {
        try {
            System.out.print("Enter Current Balance: ");
            double balance = input.nextDouble();

            System.out.print("Enter Amount to Withdraw: ");
            double amount = input.nextDouble();

            if (amount <= 0) {
                throw new Exception("Withdrawal amount must be positive");
            }

            if (amount > balance) {
                throw new Exception("Not enough balance");
            }

            balance -= amount;
            System.out.println("Withdrawal successful.");
            System.out.println("Updated Balance: " + balance);

        } catch (Exception e) {
            System.out.println("Transaction Error: " + e.getMessage());
        }
    }
}

public class lab4 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BankSystem bank = new BankSystem();

        int option;

        do {
            System.out.println("\n====== SIMPLE BANK SYSTEM ======");
            System.out.println("1. Open New Account");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Exit");

            System.out.print("Select option: ");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    bank.openAccount();
                    break;

                case 2:
                    bank.withdrawMoney();
                    break;

                case 3:
                    System.out.println("Program closed.");
                    break;

                default:
                    System.out.println("Invalid option selected.");
            }

        } while (option != 3);

        sc.close();
    }
}
