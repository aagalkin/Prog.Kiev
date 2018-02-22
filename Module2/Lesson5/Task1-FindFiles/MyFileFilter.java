import java.io.File;
import java.io.FilenameFilter;

public class MyFileFilter implements FilenameFilter {
    private String[] arrExt;
    private String ext;

    public MyFileFilter(String[] arrExt){
        this.arrExt = arrExt;
    }

    @Override
    public boolean accept(File dir, String name) {
        for (int i = 0; i < arrExt.length; i++){
            if (name.endsWith(arrExt[i])){
                return true;
            }
        }
        return false;
    }
}
