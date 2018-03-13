import java.io.*;
import java.util.Scanner;

public class FileSystem{
    private static MyFile root;
    private static File dataFile = new File("FS");
    private static Scanner scanner = new Scanner(System.in);
    private static MyFile currentDir;

    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException {
        if (dataFile.exists()){
            try (FileInputStream fileInputStream = new FileInputStream(dataFile);
                 ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)){
                root = (MyFile)objectInputStream.readObject();
                currentDir = root;
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }else {
            root = new MyFile("root");
            currentDir = root;
        }
        action();
    }

    private static void action() throws FileNotFoundException {
        while (true) {
            System.out.println(currentDir);
            String action = scanner.nextLine();
            if (action.equalsIgnoreCase("help")){
                printHelp();
            }
            else if (action.equalsIgnoreCase("exit")){
                saveFS();
                System.exit(0);
            }
            else if (action.equalsIgnoreCase("back")){
                back();
            }
            else if (action.equalsIgnoreCase("tr")){
                currentDir = root;
            }
            else if (action.equalsIgnoreCase("file")){
                createFile();
            }
            else if (action.equalsIgnoreCase("dir")){
                createFolder();
            }
            else if (action.equalsIgnoreCase("remove")){
                remove();
            }
            else {
                if (currentDir.getFile(action) != null){
                    currentDir = currentDir.getFile(action);
                }
                else {
                    System.out.println("Такой команды не существует.");
                }
            }
        }
    }

    private static void remove(){
        System.out.println("Введите имя файла/директории, который хотите удалить:");
        String name = scanner.nextLine();
        name = name.trim();
        currentDir.remove(name);
    }

    private static void createFile(){
        System.out.println("Введите имя нового файла:");
        String fileName = scanner.nextLine();
        fileName = fileName.trim();
        currentDir.mkfile(fileName);
    }

    private static void createFolder(){
        System.out.println("Введите имя нового каталога:");
        String dirName = scanner.nextLine();
        dirName = dirName.trim();
        currentDir.mkdir(dirName);
    }

    private static void back(){
        String[] path = currentDir.getPath().split("\\\\");
        if (path.length > 1){
            currentDir = root;
            for (int i = 1; i < path.length - 1; i++){
                currentDir = currentDir.getFile(path[i]);
            }
        }
    }

    private static void printHelp(){
        System.out.println();
    }

    private static void saveFS(){
        try (FileOutputStream fileOutputStream = new FileOutputStream("FS");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)){
            objectOutputStream.writeObject(root);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}