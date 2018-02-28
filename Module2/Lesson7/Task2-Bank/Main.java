import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        Account account = new Account(1000);
        Transaction[] transactions = {
                new Transaction(account, 100),
                new Transaction(account, 500),
                new Transaction(account, 200),
                new Transaction(account, 50),
                new Transaction(account, 150)
        };

        for (Transaction t : transactions){
            t.start();
        }

        for (Transaction tj : transactions){
            try {
                tj.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Total " + account.getMoney());
    }
}
