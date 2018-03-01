import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        createList();
    }

    private static void createList(){
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            list.add("abc");
        }
        list.remove(0);
        list.remove(0);
        list.remove(list.size() - 1);
        System.out.println(list);
    }
}
