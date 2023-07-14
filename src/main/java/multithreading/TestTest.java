package multithreading;

public class TestTest {

    public static void main(String[] args) {

        Runnable task1 = () -> {
            try {
                System.out.println("my name is kamar");
                Thread.sleep(300);
                System.out.println("i live in mombasa");
                Thread.sleep(300);
                System.out.println("recently i relocated to Malindi");
                Thread.sleep(300);
                System.out.println("now i'm happy");
                Thread.sleep(300);
            }
            catch (InterruptedException ignore){}
        };

        Runnable task2 = () -> {
            try {
                System.out.println("my name is makena");
                Thread.sleep(300);
                System.out.println("i live in nairobi");
                Thread.sleep(300);
                System.out.println("i'm in the develhope IT program");
                Thread.sleep(300);
                System.out.println("i'm also happy");
                Thread.sleep(300);
            }
            catch (InterruptedException ignore){}
        };

        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);

        thread1.start();
        thread2.start();

        System.out.println("thank you so much");
    }
}
