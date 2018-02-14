public abstract class Phone {
    protected String name;
    protected int imei;
    protected boolean touch;
    protected boolean hasWifi;
    protected int screenSize;
    protected int callCount;
    protected int SMSCount;
    protected int takenCallCount;
    protected SimCard sim;

    public Phone(){
        name = "Phone";
    }

    public void answer(){
        System.out.println(getName() + " is answer to call");
        takenCallCount++;
    }

    public int getTakenCallCount() {
        return takenCallCount;
    }

    public String getName() {
        return name;
    }

    public int getImei() {
        return imei;
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

    public int getNumber(){
        return sim.getNumber();
    }

    public void info(){
        System.out.println("phone name is " + getName() + ", imei: " + getImei() + ", number: " + getNumber() + ",\n" +
                "отправлено смс: " + getSMSCount() + ", сделано звонков: " + getCallCount() + ", принято звонков: " + getTakenCallCount());
    }

    public void call(int number){
        System.out.println(getName() + " is calling to " + number);
        addCallCount();
        Operator.findAbonent(number);
    }

    public void sendSMS(String number, String message){
        System.out.println(getName() + " is sending SMS" + message + " to " + number);
    }
}
