import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Monitor {
    File dir;
    Map<File, Date> map = new HashMap<>();
    SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    public Monitor(String path) throws FileNotFoundException {
        setDirection(path);
    }

    public void setDirection(String direction) throws FileNotFoundException {
        dir = new File(direction);
        if (!dir.exists()){
            throw new FileNotFoundException();
        }
        for (File file : dir.listFiles()){
            map.put(file, new Date(file.lastModified()));
        }
    }

    public void start() throws IOException, InterruptedException {
        while (true) {
            File[] files = dir.listFiles();
            findChanges(files);
            checkLastModified(files);
            Thread.sleep(2000);
        }


    }

    private void findChanges(File[] files) throws IOException {
        ArrayList<File> removingFiles = new ArrayList<>();
        Set<File> keys = map.keySet();
        boolean findFile = false;
        //Проверяем на добавление.
        for (File file : files){
            if (map.get(file) == null) {
                map.put(file, new Date(file.lastModified()));
                System.out.println("Добавлен файл " + file.getCanonicalPath() + ". Его дата последней модификации: " + format.format(map.get(file)));
            }
        }
        //Проверяем на удаление.
        for (File file : keys){
            for (File f : files){
                if (file.equals(f)){
                    findFile = true;
                }
            }
            if (!findFile){
                System.out.println("Файл " + file.getCanonicalPath() + " был удалён.");
                removingFiles.add(file);//записываем файлы, которых в директории уже нет.
                findFile = false;
            }
        }
        if (removingFiles.size() > 0){
            for(File rf : removingFiles){
                map.remove(rf);//удаляем файлы, которых уже нет в директории из списка нашего монитора.
            }
            removingFiles.clear();
        }
    }

    private void checkLastModified(File[] files) throws IOException {
        Date date = new Date();
        for (File file : files){
            date.setTime(file.lastModified());
            if (!date.equals(map.get(file))){
                map.replace(file, new Date(file.lastModified()));
                System.out.println("Файл " + file.getCanonicalPath() + " был изменён. Дата последнего изменения: " + format.format(map.get(file)));
            }
        }
    }
}
