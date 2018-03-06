import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Arraylist:");
        MyArraysList<String> myArraysList = new MyArraysList<>();
        myArraysList.add("some array-value");
        System.out.println(myArraysList.get(0));
        myArraysList.remove(0);
        //myArraysList.get(0);//ArrayIndexOutOfBoundsException

        System.out.println("LinkedList:");
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.add("some linked-value");
        myLinkedList.add("some linked-value2");
        myLinkedList.add("some linked-value3");
        System.out.println(myLinkedList.get(1));
        System.out.println(myLinkedList.get(2));
        System.out.println(myLinkedList.get(0));
        myLinkedList.remove(1);
        System.out.println(myLinkedList.get(0));
        System.out.println(myLinkedList.get(1));
        myLinkedList.add(1, "inner value");
        for (int i = 0; i < myLinkedList.size(); i++){
            System.out.println(myLinkedList.get(i));
        }
        //myLinkedList.get(3);//ArrayIndexOutOfBoundsException
    }
}
