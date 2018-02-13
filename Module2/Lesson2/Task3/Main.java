public class Main {

    public static void main(String[] args) {
        Phone phone = new Phone();
        Samsung samsung = new Samsung();
        SamsungS4 samsungS4 = new SamsungS4();

        call(phone, number);
        call(samsung, number);
        call(samsungS4, number);
        call(samsung, number);

        sendSMS(phone, number, message);
        sendSMS(samsung, number, message);
        sendSMS(samsungS4, number, message);

        System.out.println("Телефон " + phone.getName() + " Сделал " + phone.getCallCount() + " звонков и отравил " + phone.getSMSCount() + " SMS.");
        System.out.println("Телефон " + samsung.getName() + " Сделал " + samsung.getCallCount() + " звонков и отравил " + samsung.getSMSCount() + " SMS.");
        System.out.println("Телефон " + samsungS4.getName() + " Сделал " + samsungS4.getCallCount() + " звонков и отравил " + samsungS4.getSMSCount() + " SMS.");
    }

    private static String number = "555-55-55";
    private static String message = "Hello World";

    private static void call(Phone phone, String number){
        phone.call(number);
    }

    private static void sendSMS(Phone phone, String number, String message){
        phone.sendSMS(number, message);
    }
}

