import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        Monitor m = new Monitor("D:\\folder");
        m.start();
    }
}