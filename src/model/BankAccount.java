package model;

public class BankAccount {
    private String accountNumber;
    private double currentAmount;
    private Customer customer;

    public BankAccount(String accountNumber,Customer customer)
    {
        this.accountNumber=accountNumber;
        this.customer=customer;
        this.currentAmount=0;
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
            this.currentAmount += currentAmount;
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
            return true;
        }
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber='" + accountNumber + '\'' +
                ", Balance=" + currentAmount +
                ", Customer=" + customer.getName()+" "+customer.getSurname() +
                '}';
    }
}
