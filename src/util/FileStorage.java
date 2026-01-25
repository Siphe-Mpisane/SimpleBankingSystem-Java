package util;

import model.BankAccount;
import model.Customer;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class FileStorage {
    private static final String filepath = "data/accounts.txt";

    public static void saveAccounts(Collection<BankAccount> accounts) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))) {
            for (BankAccount account : accounts) {
                writer.write(
                        account.getAccountNumber() + "," +
                                account.getCustomer().getName() + "," +
                                account.getCustomer().getSurname() + "," +
                                account.getCustomer().getIdNumber() + "," +
                                account.getCustomer().getPhone() + "," +
                                account.getCustomer().getEmail() + "," +
                                account.getCurrentAmount());
            }
            ;
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error in saving accounts");
        }
    }

    public static List<BankAccount> loadaccounts() {
        List<BankAccount> accounts = new ArrayList<>();
        File file = new File(filepath);
        if (!file.exists()) return accounts;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filepath));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length < 7) continue;

                String accNumber = parts[0];
                String name = parts[1];
                String surname = parts[2];
                String idNumber = parts[3];
                String phone = parts[4];
                String email = parts[5];
                double balance = Double.parseDouble(parts[6]);

                Customer customer = new Customer(name, surname, idNumber, phone, email);
                BankAccount account = new BankAccount(accNumber, customer);
                account.deposit(balance);

                accounts.add(account);

            }
        } catch (IOException e) {
            System.out.println("Error in loading files");
        }
        return accounts;
    }
}
