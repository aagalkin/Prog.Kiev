public class Main {

    public static void main(String[] args) {
        Nokia3310 nokia3310 = new Nokia3310();
        IPhone5 iPhone5 = new IPhone5();
        SamsungS4 samsungS4 = new SamsungS4();


        nokia3310.call(iPhone5.getNumber());
        nokia3310.call(samsungS4.getNumber());
        iPhone5.call(samsungS4.getNumber());
        samsungS4.call(nokia3310.getNumber());



        nokia3310.info();
        iPhone5.info();
        samsungS4.info();
    }
}

