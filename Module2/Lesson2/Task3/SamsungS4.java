public class SamsungS4 extends Samsung {
    public SamsungS4(){
        touch = true;
        hasWifi = true;
        screenSize = 5;
        name = "SamsungS4";
    }

    @Override
    public void call(String number) {
        System.out.println("SamsungS4 is calling to " + number);
        addCallCount();
    }

    @Override
    public void sendSMS(String number, String message) {
        System.out.println("SamsungS4 is sending SMS " + message + " to " + number + "Plus word: Hello!");
        addSMSCount();
    }
}
