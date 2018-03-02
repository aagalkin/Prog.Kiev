import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int var = 7;
        int[] intArr = new int[10];
        Arrays.fill(intArr, 10);

        MyList<Integer> list = new MyList();
        list.add(var);
        for(int i : intArr){
            list.add(i);
        }
        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}

class MyList <T>{
    private T[] arr;
    private int c;

    public MyList(){
        arr = (T[]) new Object[100];
        c = 0;
    }

    public T get(int index){
        if (arr[index] == null){
            throw new ArrayIndexOutOfBoundsException();//Наш массив имеет больше элементов, чем проинициализировал пользователь.
        }
        return arr[index];
    }

    public void add(T type){
        if (c == arr.length){
            arr = Arrays.copyOf(arr, (arr.length / 100) * 30);//Если достигнут предел размера массива, то увеличиваем его на 30%
        }
        arr[c++] = type;
    }

    public int size(){
        int length = 0;
        for (T t : arr){
            if (t != null){
                length += 1;
            }
        }
        return length;//возвращаем точный размер массива без null элементов.
    }
}
