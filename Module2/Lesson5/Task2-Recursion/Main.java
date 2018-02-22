import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        try {
            list("C:\\", list);
        }
        catch (IOException e){
            System.out.println("Что-то пошло не так.");
        }

        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }

    private static void list(String path, ArrayList<String> res) throws IOException{
        File dir = new File(path);
        File[] list = dir.listFiles(((dir1, name) -> name.length() > 5 && name.charAt(1) == 'A'));

        if (list == null) return;

        for (File f : list){
            if (f.isFile()){
                res.add("File: " + f.getCanonicalPath());
            }
            else {
                res.add("Dir: " + f.getCanonicalPath());
                list(f.getPath(), res);
            }
        }
    }
}
