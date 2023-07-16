public class ThreadTest
implements Runnable{

    private String name;

    public ThreadTest(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("my name is "+ this.name);
    }
}
