import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer[] arr = new Integer[7];
        Arrays.fill(arr, 5);
        String[] arr2 = new String[6];
        Arrays.fill(arr2, "str");
        ArrayList list = convertToList(arr2);
        ArrayList list1 = convertToList(arr);
        System.out.println(list.size());
        System.out.println(list);
        System.out.println(list1.size());
        System.out.println(list1);
    }

    private static <T> ArrayList<T> convertToList(T[] arr){
        ArrayList<T> list = new ArrayList<>();
        list.addAll(Arrays.asList(arr));
        return list;
    }
}