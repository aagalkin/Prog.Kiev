public class Main {

    public static void main(String[] args) {
        Parent thread = new Parent();
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("all threads is interrupted");
    }

    static class Parent extends Thread{
        ThreadGroup group = new ThreadGroup("Thread Group");
        @Override
        public void run() {
            for (int i = 0; i < 50; i++){
                new SomeThread(group, "Thread-" + i).start();
            }
            try {
                sleep(10000);
            } catch (InterruptedException e) {
                return;
            }
            group.interrupt();
        }
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
