import java.util.Date;

public class Main{

    private static StudentList studentList = new StudentList();

    private static void print(int n){
        if (!(n < 0)) {
            System.out.println("Имя: " + studentList.get(n).getName() + "\n" +
                               "фалимия: " + studentList.get(n).getSurname() + "\n" +
                               "Дата рождения: " + studentList.get(n).getBirth() + "\n");
        }
        else {
            System.out.println("Такого студента нет в списке!");
        }
    }

    public static void main(String[] args) {

        studentList.add(new Student("Vova", "Ivanov", new Date(1986, 1, 1)));
        studentList.add(new Student("Vasya", "Pupkin", new Date(1970, 3, 28)));
        studentList.add(new Student("Petya", "Petrov", new Date(1988, 4, 25)));

        int n = studentList.findByBirth(new Date(1986, 1, 1));
        print(n);
        n = studentList.findByName("Vasya");
        print(n);
        n = studentList.findBySurname("Petrov");
        print(n);

        System.out.println("Размер списка студентов: " + studentList.getListLength());
        for (int i = 0; i < studentList.getListLength(); i++){
            System.out.println(studentList.get(i).getName());
        }
        System.out.println("");

        n = studentList.findByName("Vasya");
        studentList.remove(n);

        System.out.println("Размер списка студентов: " + studentList.getListLength());
        for (int i = 0; i < studentList.getListLength(); i++){
            System.out.println(studentList.get(i).getName());
        }
    }
}
