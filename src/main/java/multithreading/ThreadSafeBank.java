package multithreading;

import java.util.HashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * a class to simulate a bank with several accounts
 * @author kamar baraka
 * @since 17/07/2023
 */

public class ThreadSafeBank
    extends HashMap<String, Double> {

    private Lock bankLock;
    private Condition sufficientFunds;

    /**
     * construct a bank
     * @param accountName the name of the account
     * @param initialBalance the initial balance of the account*/
    public ThreadSafeBank(String accountName, double initialBalance){

        super.put(accountName, initialBalance);
        bankLock = new ReentrantLock();
        sufficientFunds = bankLock.newCondition();
    }

    /**
     * transfer funds from one account to another
     * @param fromAccount the account name to transfer from
     * @param toAccount the account name to transfer to
     * @param amount the amount to transfer*/
    public void transferFunds(String fromAccount, String toAccount, double amount){
        /*lock the section*/
        bankLock.lock();
        try{
            /*test for funds*/
            while (this.get(fromAccount) < amount){
                sufficientFunds.await();
            }

            /*debit fromAccount*/
            this.put(fromAccount, this.get(fromAccount) - amount);
            System.out.printf("transfer of %s.2f from %s(%.2f) to %s(%.2f)",
                    amount, fromAccount, this.get(fromAccount), toAccount, this.get(toAccount) );

            /*credit toAccount*/
            this.put(toAccount, this.get(toAccount) + amount);
            System.out.printf("transfer of %s.2f from %s(%.2f) to %s(%.2f)",
                    amount, fromAccount, this.get(fromAccount), toAccount, this.get(toAccount) );

            /*notifying threads in the wait set*/
            sufficientFunds.notifyAll();
        }
        catch (InterruptedException ignored){}
        finally {
            /*unlock the section*/
            bankLock.unlock();
        }
    }

    /**
     * get the total balance of all the accounts
     * @return <em>double</em> the total balance*/
    public double getTotalBalance(){
        /*compute the total balance*/
        double totalBalance = this.values().stream().reduce(Double::sum).stream().toList().get(0);
        return totalBalance;
    }
}
