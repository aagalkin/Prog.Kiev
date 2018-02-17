import java.text.SimpleDateFormat;
import java.util.Date;

public class Student {
    private String name;
    private String surname;
    private Date birth;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");

    public Student(String name, String surname, Date birth){
        this.name = name;
        this.surname = surname;
        this.birth = birth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirth() {
        return birth;
    }

    private String printBirth(){
        return simpleDateFormat.format(birth);
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public void info(){
            System.out.println("Имя: " + getName() + ", фалимия: " + getSurname() + ", Дата рождения: " + printBirth());
    }
}
