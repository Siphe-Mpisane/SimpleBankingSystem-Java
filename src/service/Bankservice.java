package service;
import model.MyHashMap;
import model.BankAccount;
import model.Customer;

import java.util.Random;

public class Bankservice {

    private MyHashMap<String,BankAccount> accounts;

    public Bankservice(){
        accounts=new MyHashMap<>();
    }

    //Search Account by account number
    public BankAccount searchAccount(String accountNumber)
    {
        return accounts.get(accountNumber);
    }

    //Deposit amount using account
    public boolean deposit (String accountNumber,double amount)
    {
        BankAccount account = searchAccount(accountNumber);
        if(account==null)
        {
            return false;
        }
        return account.deposit(amount);
    }

    //withdraw amount using account number
    public boolean withdraw(String accountNumber,double amount)
    {
        BankAccount account = searchAccount(accountNumber);

        if (account==null)
        {
            return false;
        }
        return account.withdraw(amount);
    }

    //Transfering amount (from one account to another)

    public boolean transfer(String senderAccountNum,String receiverAccountNum,double amount)
    {
        BankAccount senderAccount=searchAccount(senderAccountNum);
       BankAccount receiverAccount=searchAccount(receiverAccountNum);

        if(senderAccount==null||receiverAccount==null)
        {
            return false;
        }
        if(senderAccount.withdraw(amount)==true)
        {
            return receiverAccount.deposit(amount);
        }
        return false;
    }

    //generating random account Number
    private String generateAccountNum()
    {
        Random rand=new Random();
        String accountNumber;
        do {
            accountNumber=String.valueOf(10000+rand.nextInt(900000)) ;

        }while (accounts.containsKey(accountNumber));
        return accountNumber;
    }

}

