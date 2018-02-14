public class SamsungS4 extends Phone {
    public SamsungS4(){
        touch = true;
        hasWifi = true;
        screenSize = 5;
        name = "SamsungS4";
        imei = 2222222;
        sim = new SimCard(this);
    }

    @Override
    public void sendSMS(String number, String message) {
        System.out.println(getName() + " is sending SMS" + message + " to " + number + " plus word: Hello");
        addSMSCount();
    }
}
