package multithreading;

import java.util.ArrayList;
import java.util.Collections;

/**
 * a bank that stores multiple accounts
 * @author kamar baraka
 * @since 14/07/2023*/
public class Bank
    extends ArrayList<Double> {

    /**
     * construct a bank
     * @param numberOfAccounts the number of accounts to create
     * @param initialBalance the initial balance of each account*/
    public Bank(int numberOfAccounts, double initialBalance){

        super(numberOfAccounts);
        for (int i = 0; i < numberOfAccounts; i++)
            add(initialBalance);
        var size = super.size();
        var list = this;
    }

    /**
     * transfer amount from one account to another
     * @param transferFrom the account to transfer amount from
     * @param transferTo the account to credit the amount
     * @param amount the amount to transfer*/
    public void transfer(int transferFrom, int transferTo, double amount){

        if (this.get(transferFrom) < amount) return;
        System.out.println(Thread.currentThread());

        this.set(transferFrom, this.get(transferFrom) - amount);
        this.set(transferTo, this.get(transferTo) + amount);

        System.out.printf("%8.2f transferred from %s to %s, balance is %8.2f %n", amount, transferFrom, transferTo, this.get(
                transferFrom
        ));
    }

    /**
     * get the total balance of all the accounts
     * @return (double) the total balance*/
    public double getTotalBalance(){
        return this.stream().reduce(Double::sum).stream().toList().get(0);
    }
}
