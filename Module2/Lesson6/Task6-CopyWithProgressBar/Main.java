import java.io.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        try {
            copy("D:\\folder\\1.txt", "D:\\folder\\2.txt");
        } catch (IOException e) {
            e.getMessage();
        }
    }

    private static void copy(String srcPath, String destPath) throws IOException, InterruptedException {
        File srcFile = new File(srcPath);
        if (!srcFile.exists()){
            throw new FileNotFoundException("source file was not found");
        }
        File destFile = new File(destPath);
        if (!destFile.exists()){
            destFile.createNewFile();
        }

        try(FileInputStream inputStream = new FileInputStream(srcFile);
            FileOutputStream outputStream = new FileOutputStream(destFile)){
            int percent = ((int) (srcFile.length() / 100));
            int progress = 0;
            byte[] block = new byte[1];//Копируем по одному байту для наглядности работы прогресс бара.(Для примера был взят тхт файл размером 100байт)
            int r;
            do {
                r = inputStream.read(block, 0, block.length);
                if (r > 0){
                    outputStream.write(block);
                    progress += r / percent;
                    System.out.println("copy progress: " + progress + "%");
                    Thread.sleep(100);//Для наглядности вывода прогресс бара.
                }
                else {
                    System.out.println("copy complete");
                }

            }while (r > 0);
        }
    }
}
