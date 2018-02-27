import java.io.*;

public class Main {
    static FileInputStream inputStream;
    static FileOutputStream outputStream;
    public static void main(String[] args) throws IOException {
        CopyClass copyClass = null;
        try {
            copyClass = new CopyClass("D:\\folder\\1.txt", "D:\\folder\\2.txt");
        } catch (IOException e) {
            e.getMessage();
            System.exit(0);
        }
        try {
            SomeThread thread1 = new SomeThread(copyClass);
            thread1.start();
            thread1.join();
            SomeThread thread2 = new SomeThread(copyClass);
            thread2.start();
            thread2.join();
            SomeThread thread3 = new SomeThread(copyClass);
            thread3.start();
            thread3.join();
            SomeThread thread4 = new SomeThread(copyClass);
            thread4.start();
            thread4.join();
            SomeThread thread5 = new SomeThread(copyClass);
            thread5.start();
            thread5.join();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        inputStream.close();
        outputStream.close();
    }
}

class SomeThread extends Thread{
    CopyClass copyClass;

    public SomeThread(CopyClass copyClass){
        this.copyClass = copyClass;
    }

    @Override
    public void run() {
        try {
            copyClass.copy();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class CopyClass{
    private File scrFile;
    private File destFile;
    private byte[] block;

    public CopyClass(String srcPath, String destPath) throws IOException{
        scrFile = new File(srcPath);
        if (!scrFile.exists()){
            throw new FileNotFoundException("source file was not found!");
        }
        destFile = new File(destPath);
        if (!destFile.exists()){
            destFile.createNewFile();
        }
        block = new byte[((int)(scrFile.length() / 5))];
        Main.inputStream = new FileInputStream(scrFile);
        Main.outputStream = new FileOutputStream(destFile);
    }

    void copy() throws IOException{
        int r;
        r = Main.inputStream.read(block, 0, block.length);
        if (r > 0){
            Main.outputStream.write(block, 0, r);
        }
    }
}
