import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Operator {
    private static Map<Integer, SimCard> numberList = new HashMap<>();

    public static int setNumber(SimCard card){
        Random random = new Random();
        int number;
        while (true){
            number = random.nextInt(100000);
            if (number > 9999) { //получаем пятизначный номер.
                if (!isRepeat(number)){
                    numberList.put(number, card);
                    return number;
                }
            }
        }
    }

    public static void findAbonent(int number){
        if (numberList.get(number) != null) {
            numberList.get(number).call();
        }
        else {
            System.out.println("Такого абонента не существует!");
        }
    }

    //Проверка на повторение номера в списке.
    private static boolean isRepeat(int number){
        if (numberList.get(number) == null) {
            return false;
        }
        return true;
    }
}
