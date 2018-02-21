public class FileEvent implements IFileEvent {
    @Override
    public void onFileAdded(String s) {
        if (s.contains(".txt")){
            System.out.println("Warning! Txt file added!");
        }else {
            System.out.println("File added.");
        }
    }
}
