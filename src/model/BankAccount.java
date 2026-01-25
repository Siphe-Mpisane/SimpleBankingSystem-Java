package model;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private String accountNumber;
    private double currentAmount;
    private Customer customer;
    private List<Transaction> transactionlist;

    public BankAccount(String accountNumber,Customer customer)
    {
        this.accountNumber=accountNumber;
        this.customer=customer;
        this.currentAmount=0;
        this.transactionlist= new ArrayList<>();

    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getCurrentAmount() {
        return currentAmount;
    }

    public Customer getCustomer() {
        return customer;
    }


    public boolean deposit(double amount) {
        if(amount<=0)
        {
            return false;
        }
        else
        {
            this.currentAmount += amount;
            transactionlist.add(new Transaction("DEPOSIT",amount));
            return true;
        }

    }
    public boolean withdraw(double amount)
    {
        if(amount>currentAmount||amount<=0)
        {
            return false;
        }
        else
        {
            currentAmount-=amount;
            transactionlist.add(new Transaction("WITHDRAW",amount));
            return true;
        }
    }

    public List<Transaction> getTransactionlist()
    {
        return transactionlist;
    }

    @Override
    public String toString() {
        return "BankAccount [" +
                "accountNumber:'" + accountNumber + '\'' +
                ", Balance: " + currentAmount +
                ", Customer: " + customer.getName()+" "+customer.getSurname() +
                ']';
    }
}
