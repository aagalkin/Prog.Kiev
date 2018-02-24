import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        replace("D:\\folder\\1.txt", "Hello", "1234");
    }

    private static void replace(String path, String from, String to) throws IOException {
        String fileText = "";
        File file = new File(path);
        if (file.exists()) {
            try (BufferedInputStream reader = new BufferedInputStream(new FileInputStream(path))) {
                byte[] bytes = new byte[reader.available()];
                reader.read(bytes);
                fileText = new String(bytes);
            } catch (IOException e) {
                e.getMessage();
                System.exit(0);
            }

            if (fileText.contains(from)) {
                StringBuilder builder = new StringBuilder(fileText);
                Pattern p = Pattern.compile(from);
                Matcher m = p.matcher(builder);

                while (fileText.contains(from)) {
                    if (m.find()) {
                        builder.replace(m.start(), m.end(), to);
                        fileText = builder.toString();
                    }
                }


                try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file))) {
                    bufferedOutputStream.write(fileText.getBytes());
                } catch (IOException e) {
                    e.getMessage();
                    System.exit(0);
                }
            } else {
                try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file))) {
                    bufferedOutputStream.write(fileText.getBytes());
                } catch (IOException e) {
                    e.getMessage();
                    System.exit(0);
                }
            }
        } else {
            throw new FileNotFoundException("File not found");
        }
    }
}