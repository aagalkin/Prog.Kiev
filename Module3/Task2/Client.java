public class Client {
    private String name;
    private String surname;
    private int phone;
    private String email;

    public Client(String name, String surname, int phone, String email){
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
    }

    public Client(String name, String surname, int phone){
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        email = "";
    }

    public Client(String name, String surname, String email){
        this.name = name;
        this.surname = surname;
        this.email = email;
        phone = 0;
    }

    public Client(String name, String surname){
        this.name = name;
        this.surname = surname;
        email = "";
        phone = 0;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                '}';
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

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
