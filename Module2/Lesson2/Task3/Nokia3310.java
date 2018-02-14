public class Nokia3310 extends Phone{

    public Nokia3310(){
        name = "Nokia3310";
        hasWifi = false;
        touch = false;
        screenSize = 2;
        imei = 1111111;
        sim = new SimCard(this);
    }


}
