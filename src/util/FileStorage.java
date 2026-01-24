package util;

import model.BankAccount;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;

public class FileStorage {
    private static final String fileName = "data/accounts.txt";

    public static void saveAccounts(Collection<BankAccount> accounts) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (BankAccount account : accounts) {
                writer.write(
                        account.getAccountNumber() + "," + account.getCustomer().getName() + " " + account.getCustomer().getSurname() + "," + account.getCurrentAmount());
            };
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error in saving accounts");
        }
    }
}
