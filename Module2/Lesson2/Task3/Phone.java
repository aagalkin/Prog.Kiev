public class Phone {
    protected String name;
    protected boolean touch;
    protected boolean hasWifi;
    protected int screenSize;
    protected int callCount;
    protected int SMSCount;

    public Phone(){
        name = "Phone";
    }

    public String getName() {
        return name;
    }

    public boolean isTouch(){
        return touch;
    }

    public boolean isHasWifi(){
        return hasWifi;
    }

    public int getScreenSize(){
        return screenSize;
    }

    public int getCallCount() {
        return callCount;
    }

    public int getSMSCount() {
        return SMSCount;
    }

    public void addCallCount(){
        callCount++;
    }

    public void addSMSCount(){
        SMSCount++;
    }

    public void call(String number){
        System.out.println("Phone is calling to " + number);
        addCallCount();
    }

    public void sendSMS(String number, String message){
        System.out.println("Phone is sending SMS " + message + " to " + number);
        addSMSCount();
    }
}
