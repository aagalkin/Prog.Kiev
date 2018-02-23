import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main{
    private static BufferedWriter writer;
    private static StringBuilder tab = new StringBuilder("");
    private static SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm");
    private static Date fileCreationTime = new Date();

    public static void main(String[] args) throws IOException{
        try {
            String path = "C:\\folder1";
            File infoFile = createInfoFile(path);
            writer = new BufferedWriter(new FileWriter(infoFile));
            writeDirectoryInfo(path);
            writer.write("The End!");
        }
        catch (IOException e){
            e.getMessage();
        }
        finally {
            writer.close();
        }
    }

    private static File createInfoFile(String path) throws IOException{
        File infoFile = new File(path + "\\info.txt");
        if (!infoFile.exists()){
            infoFile.createNewFile();
        }
        return infoFile;
    }

    private static void writeDirectoryInfo(String dir) throws IOException{
        File folder = new File(dir);
        File[] files;
        if (folder.isDirectory() && folder.exists()){
            files = folder.listFiles();
        }
        else {
            throw new FileNotFoundException("Folder is not exist!");
        }

        writer.write(tab + folder.getAbsolutePath() + ":");
        writer.newLine();
        tab.append("    ");
        if (files != null) {
            for (File file : files) {
                if (!file.getName().equals("info.txt")) {
                    if (file.isFile()) {
                        fileCreationTime.setTime(file.lastModified());
                        writer.write(tab + file.getAbsolutePath() + " Дата создания: " + format.format(fileCreationTime));
                        writer.newLine();
                    } else {
                        writeDirectoryInfo(dir + "\\" + file.getName());
                    }
                }
            }
            if (tab.length() > 0) {
                tab.delete(tab.length() - 4, tab.length());
            }
        }
    }
}
