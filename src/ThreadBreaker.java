import java.util.ArrayList;
import java.util.List;

public class ThreadBreaker implements Runnable {

    private String threadName;

    public ThreadBreaker(String threadName) {
        this.threadName = threadName;
    }

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            threads.add(
                    new Thread(
                            new ThreadBreaker("Thread"+i)));

        }
        for (Thread t : threads) {
            t.start();
        }

/*
        LazyInitializedSingleton instanceOne = LazyInitializedSingleton.getInstance();
        LazyInitializedSingleton instanceTwo = null;
        System.out.println(instanceOne.hashCode());
        System.out.println(instanceTwo.hashCode());
*/
    }

    @Override
    public void run() {
        LazyInitializedSingleton instance =
                LazyInitializedSingleton.getInstance();
        ThreadSafeSingleton ts_instance =
                ThreadSafeSingleton.getInstance();
        System.out.println(
                this.getThreadName() +
                        "has lazy singleton isntance " + instance.hashCode() +
                        "and threadsafe singleton instance" + ts_instance.hashCode()
        );
    }

    private String getThreadName() {
        return threadName;
    }


}
