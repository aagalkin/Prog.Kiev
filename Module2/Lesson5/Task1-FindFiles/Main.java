import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        String[] ext = {".txt", ".bmp", "jpg"};

        try {
            findFiles("C:\\", ext, list);
        }
        catch (IOException e){
            e.printStackTrace();
        }

        for (String s : list){
            System.out.println(s);
        }
    }

    private static void findFiles(String srcPath, String[] ext, ArrayList<String> list) throws IOException{
        File dir = new File(srcPath);
        File[] files = dir.listFiles(new MyFileFilter(ext));

        for (int i = 0; i < files.length; i++){
            list.add(srcPath + files[i].getName());
        }
    }
}
