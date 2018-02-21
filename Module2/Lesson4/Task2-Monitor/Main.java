public class Main {

    public static void main(String[] args) {
        Monitor m  = new Monitor("C:\\folder","C:\\folder\\1.txt", "C:\\folder\\2.txt", new FileEvent());
        m.start();
    }
}
