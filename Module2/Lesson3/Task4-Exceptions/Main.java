import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main {
    //1 NumberFormatException
    public static boolean isDigit(String number){
        try{
           Integer.parseInt(number);
        }
        catch (NumberFormatException e){
            return false;
        }
        return true;
    }

    //2 InterruptedException
    public static void delay(int second){
        try {
            Thread.sleep(second *1000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    //3 FileNotFoundException
    public static void getFile() {
        try {
            FileInputStream stream = new FileInputStream(new File("C:\\file.file"));
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
    //4 Аналог Integer.parseInt()
    public static int parseIntAnalogue(String stringNumber) throws NumberFormatException{
        int number = 0;
        int multiplier = 1;
        if (stringNumber.matches("[0-9]+")){
            for (int i = stringNumber.length() - 1; i > -1; i--){
                number += Character.digit(stringNumber.charAt(i), 10) * multiplier;
                multiplier *= 10;
            }
        }
        else {
            throw new NumberFormatException();
        }
        return number;
    }

    //5 Использование своего Exception'a
    class MyException extends ArithmeticException{
        public MyException(String message){
            super(message);
        }

        @Override
        public String getMessage() {
            return "MyException :" + super.getMessage();
        }
    }

    public int division(int a, int b) throws MyException{
        if (b != 0){
            return a / b;
        }
        throw new MyException("Деление на ноль невозможно!");
    }

    public static void main(String[] args) {
        String number = "55453";
        int i = 0;
        try {
            i = parseIntAnalogue(number);
        }
        catch (NumberFormatException e){
            e.printStackTrace();
        }
        System.out.println(i);
//----------------------------------------------------------------------------------------------------------------------
        Main main = new Main();
        int div = 0;
        try{
            div = main.division(10, 2);
        }
        catch (MyException e){
            e.getMessage();
        }
        System.out.println(div);

    }
}
