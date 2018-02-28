public class Transaction extends Thread{
    private Account account;
    private int amount;

    public Transaction(Account account, int amount){
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        try {
            sleep(System.currentTimeMillis() % 50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        account.withdraw(amount);
    }
}
