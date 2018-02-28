import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        File file = new File("D:\\folder\\1.txt");
        if (!file.exists()){
            file.createNewFile();
        }
        TxtWriter txtWriter = new TxtWriter(file);

        new SomeThread(txtWriter, "abc").start();
        new SomeThread(txtWriter, "hello").start();
        new SomeThread(txtWriter, "world").start();
        new SomeThread(txtWriter, "banana").start();
        new SomeThread(txtWriter, "kuku").start();

        Thread.sleep(5000);

        txtWriter.closeWriter();
    }
}

class SomeThread extends Thread{
    private TxtWriter txtWriter;
    private String message;

    public SomeThread(TxtWriter txtWriter, String message){
        this.txtWriter = txtWriter;
        this.message = message;
    }

    @Override
    public void run() {
        try {
            txtWriter.write(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class TxtWriter{
    private FileWriter writer;

    public TxtWriter(File file) throws IOException {
        writer = new FileWriter(file);
    }

    synchronized void write(String text) throws IOException {
        writer.write(text + "\n");
    }

    void closeWriter() throws IOException {
        writer.close();
    }
}
