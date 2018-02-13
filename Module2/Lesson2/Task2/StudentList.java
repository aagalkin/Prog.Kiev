import java.util.Arrays;
import java.util.Date;

public class StudentList {
    private Student list[] = new Student[1];
    private int p = 0;

    public void add(Student s){
        if (p > list.length - 1) {
            list = Arrays.copyOf(list, list.length + 1);
            list[p++] = s;
        }else{
            list[p++] = s;
        }
    }

    public int getListLength(){
        return list.length;
    }

    public Student get(int n){
        return list[n];
    }

    public int findByName(String name){
        for (int i = 0; i < list.length; i++){
            if (list[i].getName().equalsIgnoreCase(name)){
                return i;
            }
        }
        return -1;
    }

    public int findBySurname(String surname){
        for (int i = 0; i < list.length; i++){
            if (list[i].getSurname().equalsIgnoreCase(surname)){
                return i;
            }
        }
        return -1;
    }

    public int findByBirth(Date birth){
        for (int i = 0; i < list.length; i++){
            if (list[i].getBirth().equals(birth)){
                return i;
            }
        }
        return -1;
    }

    public void remove(int student){
        Student tmpList[] = new Student[list.length - 1];
        for (int i = 0, j = 0; i < list.length; i++){
            if (i != student) {
                tmpList[j] = list[i];
                j++;
            }
        }
        list = Arrays.copyOf(tmpList, tmpList.length);
    }
}
