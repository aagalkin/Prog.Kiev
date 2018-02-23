import java.io.*;
import java.util.Scanner;

public class Main{
    private static BufferedWriter writer;
    private static StringBuilder tab = new StringBuilder("");

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
        String[] files;
        if (folder.isDirectory() && folder.exists()){
            files = folder.list();
        }
        else {
            throw new FileNotFoundException("Folder is not exist!");
        }

        writer.write(tab + dir + ":");
        writer.newLine();
        tab.append("    ");
        System.out.println(dir + ":");
        for (String file : files){
            if (!file.equals("info.txt")) {
                if (new File(dir + "\\" + file).isFile()) {
                    writer.write(tab + file);
                    writer.newLine();
                    System.out.println(file);
                }
                else {
                    writeDirectoryInfo(dir + "\\" + file);
                }
            }
        }
        if (tab.length() > 0){
            tab.delete(tab.length() - 4, tab.length());
        }
    }
}
