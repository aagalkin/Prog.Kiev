import java.util.Date;
import java.util.Scanner;

public class Main{
    private static Scanner scanner = new Scanner(System.in);
    private static StudentList studentList = new StudentList();

    public static void main(String[] args) {

        while (true) {
            System.out.println("Выберите действите: \nlist - Показать весь список студентов. \nadd - Добавить нового студента. \nremove - Удалить студента по его номеру в списке. \nexit - для выхода");
            action(scanner.nextLine());
        }
    }

    private static void action(String action){
        if (action.equalsIgnoreCase("list")){
            studentList.listInfo();
        }
        else if (action.equalsIgnoreCase("add")){
            addStudent();
        }
        else if (action.equalsIgnoreCase("remove")){
            removeStudent();
        }
        else if (action.equalsIgnoreCase("exit")){
            System.exit(0);
        }
    }

    //добавление студента
    private static void addStudent(){
        System.out.println("Введите имя студента:");
        String name = scanner.nextLine();
        System.out.println("Введите фамилию студента:");
        String surname = scanner.nextLine();
        int year;
        int month;
        int day;
        while (true){
            String sYear, sMonth, sDay;
            System.out.println("Введите год рождения:");
            sYear = scanner.nextLine();
            if (isDigit(sYear)){
                if (checkYear(Integer.parseInt(sYear))){
                    year = Integer.parseInt(sYear);
                }
                else {
                    System.out.println("Год не может быть больше текущего!");
                    continue;
                }
            }
            else {
                System.out.println("Не верный формат!");
                continue;
            }
            System.out.println("Введите месяц рождения:");
            sMonth = scanner.nextLine();
            if (isDigit(sMonth)){
                if (checkMonth(Integer.parseInt(sMonth))){
                    month = Integer.parseInt(sMonth) - 1;
                }
                else {
                    System.out.println("Такого месяца на существует!");
                    continue;
                }
            }
            else {
                System.out.println("Не верный формат!");
                continue;
            }
            System.out.println("Введите день рождения:");
            sDay = scanner.nextLine();
            if (isDigit(sDay)){
                if (checkDay(year, month, Integer.parseInt(sDay))){
                    day = Integer.parseInt(sDay);
                }
                else {
                    System.out.println("Такого дня в этом месяце не существует");
                    continue;
                }
            }
            else {
                System.out.println("Не верный формат!");
                continue;
            }
            break;
        }
        name = name.trim();
        name = Character.toUpperCase(name.charAt(0)) + name.substring(1);
        surname = surname.trim();
        surname = Character.toUpperCase(surname.charAt(0)) + surname.substring(1);
        studentList.add(new Student(name, surname, new Date(year - 1900, month, day)));
        System.out.println("Студент успешно добавлен");
    }

    //Удаление студента
    public static void removeStudent(){
        System.out.println("Введите номер студента в списке:");
        String number = scanner.nextLine();
        if (isDigit(number)){
            try {
                studentList.remove(Integer.parseInt(number) - 1);
                System.out.println("Студент успешно удалён.");
            }
            catch (MyException e){
                System.out.println(e.getMessage());
            }
        }
    }

    //Проверка на цифру
    private static boolean isDigit(String number){
        try {
            Integer.parseInt(number);
        }
        catch (NumberFormatException e){
            return false;
        }
        return true;
    }

    //Высокостный год
    private static boolean isLeapYear(int year){
        if (year % 4 == 0){
            return true;
        }
        return false;
    }

    //Границы дней месяца
    private static boolean checkDay(int year, int month, int day){
        int dayLimit = 0;
        if (month == 0 || month == 2 || month == 4 || month == 6 || month == 7 || month == 9 || month == 11){
            dayLimit = 31;
        }
        else if (month == 3 || month == 5 || month == 8 || month == 10){
            dayLimit = 30;
        }
        else if (month == 1){
            if (isLeapYear(year)){
                dayLimit = 29;
            }
            else {
                dayLimit = 28;
            }
        }

        if (day > dayLimit || day < 1){
            return false;
        }
        return true;
    }

    //Границы месяца года
    private static boolean checkMonth(int month){
        if (month > 12 || month < 1){
            return false;
        }
        return true;
    }

    //Если год больше текущего
    private static boolean checkYear(int year){
        if (year > (new Date().getYear() + 1900)){
            return false;
        }
        return true;
    }
}
