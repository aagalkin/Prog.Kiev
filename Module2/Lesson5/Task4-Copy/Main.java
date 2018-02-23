import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Main {


    public static void main(String[] args) throws IOException {
        copyFolder("C:\\folder1", "C:\\folder2");
    }

    private static void copyFolder(String source, String dest) throws IOException{
        File fSource = new File(source);
        File fDest = new File(dest);
        String[] sourceList;
        if (fSource.exists() && fSource.isDirectory()) {
            sourceList = fSource.list();
        }
        else {
            throw new FileNotFoundException("Source folder is not exist!");
        }

        if (!fDest.exists()) {
            fDest.mkdir();
        }

        if (sourceList != null) {
            for (String file : sourceList) {
                if(new File(source + "\\" + file).isFile()) {
                    Files.copy(Paths.get(source + "\\" + file), Paths.get(dest + "\\" + file), StandardCopyOption.REPLACE_EXISTING);
                }
                else {
                    copyFolder(source + "\\" + file, dest + "\\" + file);
                }
            }
        }
    }
}
