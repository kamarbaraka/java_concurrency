import java.util.ArrayList;

public class ConcurrencyTest {

    public static void main(String[] args) {
        Thread thread1;
        Thread thread2;
        Thread thread3;

        ThreadTest task3 = new ThreadTest("John");

        Runnable task1 = () -> {
            try {
                System.out.println(Thread.currentThread().isDaemon());
                System.out.println("hello");
                Thread.sleep(500);
                System.out.println("developers");
                Thread.sleep(300);
            }
            catch (InterruptedException ignore){
                System.out.println("interrupted");
            }
        };

        Runnable task2 = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().isDaemon());
                    System.out.println("today");
                    Thread.sleep(300);
                    System.out.println("Its a good day");
                    Thread.sleep(1000);
                    ArrayList<String> array = new ArrayList<>();
                    System.out.println(array.get(1));
                }
                catch (InterruptedException ignore){}
            }
        };

        thread1 = new Thread(task1);
        thread2 = new Thread(task2);
        thread3 = new Thread(task3);

        thread2.setDaemon(true);
        thread2.setUncaughtExceptionHandler((thread, exception) -> {
            System.err.printf("error: %s from %s %n", exception, thread);
        });

        thread1.start();
        thread2.start();
        thread1.interrupt();
        thread3.start();

        try
        {
            thread1.join();
            thread2.join();
            thread3.join();
        }
        catch (InterruptedException ignore){}

        System.out.println("thank you");

        System.out.println(Thread.currentThread().getState());

    }
}
