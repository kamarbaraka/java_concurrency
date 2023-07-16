public class ConcurrencyTest {

    public static void main(String[] args) {

        ThreadTest task3 = new ThreadTest("John");

        Runnable task1 = () -> {
            try {
                System.out.println("hello");
                Thread.sleep(500);
                System.out.println("developers");
                Thread.sleep(300);
            }
            catch (InterruptedException ignore){}
        };

        Runnable task2 = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("today");
                    Thread.sleep(300);
                    System.out.println("Its a good day");
                    Thread.sleep(1000);
                }
                catch (InterruptedException ignore){}
            }
        };

        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);
        Thread thread3 = new Thread(task3);

        thread1.start();
        thread2.start();
        thread3.start();

        System.out.println("thank you");

    }
}
