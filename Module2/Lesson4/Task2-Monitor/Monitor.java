import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class Monitor {
    private String file;
    private String file2;
    private IFileEvent event;
    private String directory;
    private File f;
    private File f2;
    private File d;

    public Monitor(String directory, String file, String file2, IFileEvent event) {
        this.directory = directory;
        this.file = file;
        this.file2 = file2;
        this.event = event;
        this.f = new File(this.file);
        this.f2 = new File(this.file2);
        this.d = new File(this.directory);
    }

    private boolean isFileAlredyAdded(File file){
        for (String f : d.list()){
            if (f.equals(file.getName())){
                return true;
            }
        }
        return false;
    }

    private boolean isAllFilesAdded(File file1, File file2){
        return isFileAlredyAdded(file1) && isFileAlredyAdded(file2);
    }

    public void start(){
        while (true){

            if (d.exists() && d.isDirectory()) {
                if (f.exists() && f.isFile()) {
                    if (event != null) {
                        if (!isFileAlredyAdded(f)){
                            event.onFileAdded(file);
                        }
                    }
                }
                if (f2.exists() && f2.isFile()){
                    if (event != null) {
                        if (!isFileAlredyAdded(f2)) {
                            event.onFileAdded(file2);
                        }
                    }
                }
                if (isAllFilesAdded(f, f2)) {
                    break;
                }
            }

            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }

            System.out.println("Waiting...");
        }
    }
}
