import java.util.Arrays;
import java.util.Iterator;

public class MyArraysList <T extends Object>{
    private T[] list;
    private int bound;
    private int listSize;

    public MyArraysList(){
        listSize = 10;//Дефалтовая длина массива в ArrayList
        list = (T[]) new Object[listSize];
        bound = 0;
    }

    //Конструктор с задаваемой начальной длиной массива
    public MyArraysList(int listSize){
        this.listSize = listSize;
        list = (T[]) new Object[listSize];
        bound = 0;
    }

    //добавление
    public void add(T value){
        if (bound == list.length){
            if (bound != Integer.MAX_VALUE) {
                if ((list.length + ((list.length / 100) * 30)) <= Integer.MAX_VALUE) {
                    list = Arrays.copyOf(list, list.length + ((list.length / 100) * 30));//Если достигли предела размера массива, то прибавляем к размеру массива 30%
                } else {
                    list = Arrays.copyOf(list, Integer.MAX_VALUE);
                }
            }
            else {
                System.out.println("Достигнут максимальный размер массива!");
                return;
            }
        }
        list[bound++] = value;
    }

    //добавление в середину
    public void add(int index, T value){
        if (index > bound && index < 0){
            throw new IndexOutOfBoundsException();
        }
        else if (index == bound){
            add(value);
        }
        else {
            if (bound == list.length) {
                if (bound != Integer.MAX_VALUE) {
                    if ((list.length + ((list.length / 100) * 30)) <= Integer.MAX_VALUE) {
                        list = Arrays.copyOf(list, list.length + ((list.length / 100) * 30));
                    } else {
                        list = Arrays.copyOf(list, Integer.MAX_VALUE);
                    }
                } else {
                    System.out.println("Достигнут максимальный размер массива!");
                    return;
                }
            }
            System.arraycopy(list, index, list, index + 1, bound - index);
            list[index] = value;
        }
    }

    //получение
    public T get(int index){
        if (index >= bound || index < 0){
            throw new IndexOutOfBoundsException();
        }
        return list[index];
    }

    //удаление
    public T remove(int index){
        if (index >= bound || index < 0){
            throw new IndexOutOfBoundsException();
        }
        T returnValue = list[index];
        if (index == bound - 1){
            list[bound - 1] = null;
        }
        else {
            System.arraycopy(list, index + 1, list, index, list.length - index);
        }
        bound--;
        return returnValue;
    }

    //очистка
    public void clear(){
        list = Arrays.copyOf(list, listSize);
        Arrays.fill(list, null);
        bound = 0;
    }

    //размер
    public int size(){
        return bound;
    }
}
