import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        File file1 = new File("D:\\folder\\1.txt");
        File file2 = new File("D:\\folder\\2.txt");
        File file3 = new File("D:\\folder\\3.txt");

        if (!file1.exists() && !file2.exists()){
            throw new FileNotFoundException();
        }

        if (!file3.exists()){
            file3.createNewFile();
        }

        try (SequenceInputStream sequenceInputStream = new SequenceInputStream(new FileInputStream(file1), new FileInputStream(file2));
             FileOutputStream fileOutputStream = new FileOutputStream(file3)){
            int b;
            while (true){
                if ((b = sequenceInputStream.read()) != -1){
                    fileOutputStream.write(b);
                }
                else {
                    break;
                }
            }
        }
        catch (IOException e){
            e.getMessage();
        }
    }
}
