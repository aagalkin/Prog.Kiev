import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();
    public static void main(String[] args) {
        lock.lock();
        Counter counter = new Counter();
        counter.start();
        try {
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
    }

    static class Counter extends Thread{
        @Override
        public void run() {
            lock.lock();
            final int MIN = 100;
            final int MAX = 200;
            int x = 1;

            while (x <= MAX) {
                if (x >= MIN && x <= MAX){
                    System.out.println(x++);
                }
                else {
                    x++;
                }
                if (x >= MIN) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            condition.signal();
            lock.unlock();
        }
    }
}


