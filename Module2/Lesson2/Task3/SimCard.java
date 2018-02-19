public class SimCard {
    private int number;
    private Phone phone;

    public SimCard(Phone phone){
        number = Operator.setNumber(this);
        this.phone = phone;
    }

    public int getNumber() {
        return number;
    }

//    public void call(){
//        phone.answer();
//    }


    public Phone getPhone() {
        return phone;
    }
}
