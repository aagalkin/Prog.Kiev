public class Samsung extends Phone {
    public Samsung(){
        touch = true;
        hasWifi = true;
        name = "Samsung";
    }

    @Override
    public void call(String number) {
        System.out.println("Samsung is calling to " + number);
        addCallCount();
    }



    @Override
    public void sendSMS(String number, String message) {
        System.out.println("Samsung is sending SMS " + message + " to " + number);
        addSMSCount();
    }
}
