import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        String action;
        TimeThread currentTime = new TimeThread();
        currentTime.start();
        System.out.println("write \"stop\" to stop program");
        while (true){
            action = scanner.nextLine();
            if (action.equalsIgnoreCase("stop")){
                currentTime.interrupt();
                break;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class TimeThread extends Thread{
    @Override
    public void run() {
        Date currentTime = new Date();
        while (true){
            currentTime.setTime(System.currentTimeMillis());
            System.out.println(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(currentTime));
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
