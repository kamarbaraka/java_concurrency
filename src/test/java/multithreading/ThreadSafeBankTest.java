package multithreading;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThreadSafeBankTest {

    @Test
    public void threadSafeBankTest(){

        ThreadSafeBank bank = new ThreadSafeBank("account1", 25000);
        bank.put("account2", 12486.0);
        bank.put("account3", 1457.0);
        bank.put("account4", 12567.0);
        bank.put("account5", 3547.0);
        bank.put("account6", 4578.0);

        Thread task1 = new Thread(() -> {
            for (int i = 0; i < 5; i++){
                try
                {
                    bank.transferFunds("account4", "account1", 20000);
                    Thread.sleep(400);
                }
                catch (InterruptedException ignored){}
            }
        });Thread task2 = new Thread(() -> {
            for (int i = 0; i < 5; i++){
                try
                {
                    bank.transferFunds("account5", "account2", 20000);
                    Thread.sleep(400);
                }
                catch (InterruptedException ignored){}
            }
        });Thread task3 = new Thread(() -> {
            for (int i = 0; i < 5; i++){
                try
                {
                    bank.transferFunds("account1", "account2", 20000);
                    Thread.sleep(400);
                }
                catch (InterruptedException ignored){}
            }
        });/*Thread task4 = new Thread(() -> {
            for (int i = 0; i < 5; i++){
                try
                {
                    bank.transferFunds("account2", "account3", 20000);
                    Thread.sleep(400);
                }
                catch (InterruptedException ignored){}
            }
        });
*/
        task1.start();
        task2.start();
        task3.start();
//        task4.start();

    }

}