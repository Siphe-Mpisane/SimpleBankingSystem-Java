package main;

import model.BankAccount;
import model.Customer;
import model.Transaction;
import util.FileStorage;
import service.Bankservice;

import javax.swing.*;
import java.util.Scanner;

public class Bankapp {
    private Bankservice bankservice = new Bankservice();
    private  Scanner scanner = new Scanner(System.in);
    public  FileStorage storage=new FileStorage();

    public static void main(String[] args) {

        Bankapp runner = new Bankapp();
        runner.bankservice.loadFroFile();
        int option = 0;
        do {
            option = runner.options();
            System.out.println();
            // scanner.nextLine();
            switch (option) {
                case 1:
                    runner.creteAccount();
                    break;
                case 2:
                    runner.deposit();

                    break;
                case 3:
                    runner.withdraw();
                    break;
                case 4:
                    runner.transfer();
                    break;
                case 5:
                    runner.viewAccount();
                    break;
                default:
                    System.out.println("Please choose from the Available Options.");

            }

        } while (option != 6);

        System.out.println("Exiting...");


    }

    private int options() {
        System.out.println("************************************");
        System.out.println("            BANK SYSTEM              ");
        System.out.println("*************************************");
        System.out.println("1. Create Account");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Transfer");
        System.out.println("5. View account");
        System.out.println("6. Exit");
        System.out.print("Choice: ");
        return Integer.parseInt(scanner.nextLine());

    }

    private void creteAccount() {
        String name, surname, idNumber, email, phone;

        System.out.print("Name: ");
        name = scanner.nextLine();

        System.out.print("Surname: ");
        surname = scanner.nextLine();

        System.out.print("ID Number: ");
        idNumber = scanner.nextLine();

        System.out.print("Email: ");
        email = scanner.nextLine();

        System.out.print("phone: ");
        phone = scanner.nextLine();

        Customer customer = new Customer(name, surname, idNumber, phone, email);
        BankAccount account = bankservice.createAccount(customer);
        System.out.println("Account created: " + account.getAccountNumber());
        bankservice.saveTofile();
    }

    //Depositing Money into the bank
    private void deposit() {
        String accountNumber;
        double amount;
        System.out.print("Account number: ");
        accountNumber = scanner.nextLine();

        System.out.print("Amount: ");
        amount = Double.parseDouble(scanner.nextLine());

        if (bankservice.deposit(accountNumber, amount)) {
            System.out.println("Deposit Successful");
            bankservice.saveTofile();

        } else {
            System.out.println("deposit failed");
        }
    }

    //withdrawing Money from a bank
    private void withdraw() {
        String accountNumber;
        double amount;
        System.out.print("Account number: ");
        accountNumber = scanner.nextLine();

        System.out.print("Amount: ");
        amount = Double.parseDouble(scanner.nextLine());

        if (bankservice.withdraw(accountNumber, amount)) {
            System.out.println("Withdrawal Successful");
            bankservice.saveTofile();
        } else {
            System.out.println("withdrawal failed");
        }

    }

    //Transfering Money form one bank to another
    private void transfer() {
        String senderAcc, receiverAcc;
        double amount;
        System.out.print("From Account: ");
        senderAcc = scanner.nextLine();

        System.out.print("To Account: ");
        receiverAcc = scanner.nextLine();

        System.out.print("Amount: ");
        amount = Double.parseDouble(scanner.nextLine());
        ;

        if (bankservice.transfer(senderAcc, receiverAcc, amount)) {
            System.out.println("Transfer Successful");
        } else {
            System.out.println("Transfer failed");
        }
    }

    //Viewing account Balance and Transactions Made
    private void viewAccount() {
        {
            System.out.print("Account Number: ");
            String accNumber = scanner.nextLine();

            BankAccount account = bankservice.searchAccount(accNumber);
            if (account != null) {
                System.out.println(account);

                for (Transaction transaction : account.getTransactionlist()) {
                    System.out.println(transaction);
                }

            } else {
                System.out.println("account not found.");
            }
        }
    }


}
