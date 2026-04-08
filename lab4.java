import java.io.*;
import java.util.*;

// Custom Exceptions
class InvalidCIDException extends Exception {
    InvalidCIDException(String msg) {
        super(msg);
    }
}

class InvalidAmountException extends Exception {
    InvalidAmountException(String msg) {
        super(msg);
    }
}

class LowBalanceException extends Exception {
    LowBalanceException(String msg) {
        super(msg);
    }
}

class Bank {

    Scanner sc = new Scanner(System.in);
    File file = new File("accounts.txt");

    // Check account existence
    boolean accountExists(int cid) {
        if (!file.exists())
            return false;

        try (Scanner fr = new Scanner(file)) {
            while (fr.hasNext()) {
                int id = fr.nextInt();
                fr.next();
                fr.nextDouble();

                if (id == cid)
                    return true;
            }
        } catch (Exception e) {
            System.out.println("File Read Error");
        }
        return false;
    }

    // Create Account
    void createAccount() {
        try {
            System.out.print("Enter CID (1–20): ");
            int cid = sc.nextInt();

            if (cid < 1 || cid > 20)
                throw new InvalidCIDException("CID must be between 1 and 20");

            if (accountExists(cid))
                throw new Exception("Account already exists!");

            System.out.print("Enter Name: ");
            String name = sc.next();

            System.out.print("Enter Amount: ");
            double amount = sc.nextDouble();

            if (amount <= 0)
                throw new InvalidAmountException("Amount must be positive");

            if (amount < 1000)
                throw new LowBalanceException("Minimum balance is Rs.1000");

            try (FileWriter fw = new FileWriter(file, true)) {
                fw.write(cid + " " + name + " " + amount + "\n");
            }

            System.out.println("Account Created Successfully!");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Deposit
    void deposit() {
        try {
            System.out.print("Enter CID: ");
            int cid = sc.nextInt();

            if (!accountExists(cid))
                throw new Exception("Account not found!");

            System.out.print("Enter Deposit Amount: ");
            double dep = sc.nextDouble();

            if (dep <= 0)
                throw new InvalidAmountException("Amount must be positive");

            File tempFile = new File("temp.txt");

            try (Scanner fr = new Scanner(file);
                 FileWriter fw = new FileWriter(tempFile)) {

                while (fr.hasNext()) {
                    int id = fr.nextInt();
                    String name = fr.next();
                    double balance = fr.nextDouble();

                    if (id == cid) {
                        balance += dep;
                        System.out.println("Deposit Successful!");
                        System.out.println("Updated Balance: " + balance);
                    }

                    fw.write(id + " " + name + " " + balance + "\n");
                }
            }

            file.delete();
            tempFile.renameTo(file);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Withdraw
    void withdraw() {
        try {
            System.out.print("Enter CID: ");
            int cid = sc.nextInt();

            if (!accountExists(cid))
                throw new Exception("Account not found!");

            System.out.print("Enter Withdrawal Amount: ");
            double amt = sc.nextDouble();

            if (amt <= 0)
                throw new InvalidAmountException("Amount must be positive");

            File tempFile = new File("temp.txt");

            try (Scanner fr = new Scanner(file);
                 FileWriter fw = new FileWriter(tempFile)) {

                while (fr.hasNext()) {
                    int id = fr.nextInt();
                    String name = fr.next();
                    double balance = fr.nextDouble();

                    if (id == cid) {
                        if (amt > balance)
                            throw new LowBalanceException("Insufficient Balance");

                        balance -= amt;

                        System.out.println("Withdrawal Successful!");
                        System.out.println("Remaining Balance: " + balance);
                    }

                    fw.write(id + " " + name + " " + balance + "\n");
                }
            }

            file.delete();
            tempFile.renameTo(file);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Display All Accounts
    void display() {
        if (!file.exists()) {
            System.out.println("No records found!");
            return;
        }

        try (Scanner fr = new Scanner(file)) {
            System.out.println("\nCID\tName\tBalance");
            System.out.println("-------------------------");

            while (fr.hasNext()) {
                int id = fr.nextInt();
                String name = fr.next();
                double balance = fr.nextDouble();

                System.out.println(id + "\t" + name + "\t" + balance);
            }

        } catch (Exception e) {
            System.out.println("Error reading file");
        }
    }
}

public class  lab4 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();
        int choice;

        do {
            System.out.println("\n===== BANK MENU =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Display All");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    bank.createAccount();
                    break;
                case 2:
                    bank.deposit();
                    break;
                case 3:
                    bank.withdraw();
                    break;
                case 4:
                    bank.display();
                    break;
                case 5:
                    System.out.println("Thank You!");
                    break;
                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 5);

        sc.close();
    }
}
