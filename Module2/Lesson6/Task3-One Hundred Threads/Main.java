public class Main {
    public static void main(String[] args) {
        ThreadGroup group = new ThreadGroup("my group");

        for (int i = 0; i < 100; i++){
            new SomeThread(group, "Thread-" + i).start();
        }

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        group.interrupt();

    }

    static class SomeThread extends Thread{

        public SomeThread(ThreadGroup group, String name){
            super(group, name);
        }

        @Override
        public void run() {
            System.out.println(getName() + " is waiting...");
            while (true){
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    System.out.println(getName() + " is interrupted");
                    return;
                }
            }
        }
    }
}


