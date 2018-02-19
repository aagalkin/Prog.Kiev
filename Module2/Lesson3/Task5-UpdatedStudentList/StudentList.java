import java.util.Arrays;
import java.util.Date;

public class StudentList {
    private Student list[] = new Student[0];
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
            if(list[i] != null) {
                if (list[i].getName().equalsIgnoreCase(name)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int findBySurname(String surname){
        for (int i = 0; i < list.length; i++){
            if (list[i] != null) {
                if (list[i].getSurname().equalsIgnoreCase(surname)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int findByBirth(Date birth){
        for (int i = 0; i < list.length; i++){
            if (list[i] != null) {
                if (list[i].getBirth().equals(birth)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public void remove(int student) throws MyException{
        if (student >= 0 && student < list.length){
            try {
                System.arraycopy(list, student + 1, list, student, list.length - (student + 1));//Если будем удалять последнего студента, то может вылезти за края массмва.
                list[list.length - 1] = null;
            }
            catch (ArrayIndexOutOfBoundsException e){
                list[list.length - 1] = null;
            }
            finally {
                p--;
            }
        }
        else {
            throw new MyException("Такого студента нет в списке!");
        }
    }

    public void listInfo(){
        if (list.length > 0) {
            for (int i = 0; i < list.length; i++) {
                System.out.print(i + 1 + ".");
                get(i).info();
            }
            System.out.println("");
        }
        else {
            System.out.println("Список студентов пуст.\n");
        }
    }
}
