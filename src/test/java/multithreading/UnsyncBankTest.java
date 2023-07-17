package multithreading;

import org.junit.jupiter.api.Test;

/**
 * a test class for asynchronous threads and the race condition
 * @author kamar baraka
 * /@since 17/07/2023*/

public class UnsyncBankTest {

    private final double MAX_AMOUNT = 1000;
    private final int DELAY = 10;
    private final double INITIAL_BALANCE = 1000;
    private final int NO_ACCOUNTS = 100;

    /**
     * method to test the class,
     * it tests how the class works*/
    @Test
    public void un_syncBankTest(){
        Bank bank = new Bank(NO_ACCOUNTS, INITIAL_BALANCE);
        System.out.println("welcome");
        Bank bank1 = new Bank(2, 25400);

        for (int i = 0; i < NO_ACCOUNTS; i++){
            int fromAccount = i;

            Runnable task = () -> {
                try{

                    while (true){

                        bank.transfer(fromAccount, (int) (bank.size() * Math.random()), MAX_AMOUNT * Math.random());
                        Thread.sleep((long) (DELAY * Math.random()));

                    }
                }
                catch (InterruptedException ignored){}
            };
            Runnable task1 = () -> {
                try{

                    while (true){

                        bank.transfer(fromAccount, (int) (bank.size() * Math.random()), MAX_AMOUNT * Math.random());
                        Thread.sleep((long) (DELAY * Math.random()));

                    }
                }
                catch (InterruptedException ignored){}
            };

            Thread thread = new Thread(task);
            Thread thread1 = new Thread(task1);
            thread.start();
            thread1.start();

        }
    }
}
