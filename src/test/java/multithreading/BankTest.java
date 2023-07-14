package multithreading;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {

    private final int MAX_AMOUNT = 1000;
    private final int DELAY = 10;
    private final int STEPS = 50;
    @Test
    public void bankTest(){

        Bank bank = new Bank(4, 100000);

        Runnable task1 = () -> {
            try{
                for (int i = 0; i < STEPS; i++){
                    bank.transfer(0, 1, MAX_AMOUNT * Math.random());
                    Thread.sleep((int) (DELAY * Math.random()));
                }
            }
            catch (InterruptedException ignore){}
        };
        Runnable task2 = () -> {
            try{
                for (int i = 0; i < STEPS; i++) {
                    bank.transfer(2, 3, MAX_AMOUNT * Math.random());
                    Thread.sleep((int) (DELAY * Math.random()));
                }
            }
            catch (InterruptedException ignore){}
        };

        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);

        thread1.start();
        thread2.start();

    }

}