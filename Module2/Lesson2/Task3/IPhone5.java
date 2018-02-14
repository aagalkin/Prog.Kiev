public class IPhone5 extends Phone{
    public IPhone5(){
        screenSize = 4;
        imei = 3333333;
        touch = true;
        hasWifi = true;
        name = "IPhone5";
        sim = new SimCard(this);
    }
}
