package Application;

import Entities.Account;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Account account;

        System.out.print("Enter the account number: ");
        int accountNumber = sc.nextInt();

        System.out.print("Enter the account holder: ");
        sc.nextLine();
        String accountName = sc.nextLine();
        System.out.print("Is there an initial deposit (y/n)? ");
        char response = sc.next().charAt(0);

        if (response == 'y' || response == 'Y') {
            System.out.println("Enter initial deposit value: ");
            double initialDeposit = sc.nextDouble();
            account = new Account(accountNumber, accountName, initialDeposit);
        }
        else {
            account = new Account(accountNumber, accountName);
        }

        System.out.println("Account data -");
        System.out.println(account);

        boolean turnoff = false;
        while(!turnoff) {
            System.out.println("Do you want do make a deposit or withdraw? Type 'exit' to leave");
            String choice = sc.next();

            if (choice.equalsIgnoreCase("deposit")) {
                System.out.print("Enter a deposit value:");
                double amount = sc.nextDouble();
                account.deposit(amount);
                System.out.println("Updated account data: " + account);
            } else if (choice.equalsIgnoreCase("withdraw")) {
                System.out.println("Enter a withdraw value:");
                double amount = sc.nextDouble();
                account.withdraw(amount);
                System.out.println("Updated account data: " + account);
            } else {
                turnoff = true;
                System.out.println("Operation finished.");
            }
        }
        sc.close();
    }
}
