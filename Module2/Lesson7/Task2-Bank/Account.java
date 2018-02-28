public class Account {
    private int money;

    public Account(int money){
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void withdraw(int amount) {
        Main.lock.lock();
        if (money >= amount){
            money -= amount;
        }
        else {
            System.out.println("Not enough money!");
        }
        Main.lock.unlock();
    }
}
