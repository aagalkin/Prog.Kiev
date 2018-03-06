import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{
    private static Scanner scanner = new Scanner(System.in);
    private static File dataFile = new File("Human");

    public static void main(String[] args) {
        if (dataFile.exists()){
            if (dataFile.length() > 0){
                readObjects();
            }
        }
        else {
            writeObjects();
        }
    }

    private static void readObjects(){
        try (FileInputStream fileInputStream = new FileInputStream(dataFile);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)){
            while (true){
                try {
                    System.out.println(objectInputStream.readObject());
                }
                catch (EOFException e){
                    break;
                }
            }
        }
        catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }


    private static void writeObjects(){
        List<Human> humans = new ArrayList<>();
        int humansCount = 2;
        for (int i = 0; i < humansCount; i++) {
            System.out.println("Введите имя человека №" + (i + 1) + ":");
            String name = scanner.nextLine();
            name.trim();
            name = Character.toUpperCase(name.charAt(0)) + name.substring(1);
            System.out.println("Введите возраст(полных лет):");
            int age;
            while (true) {
                String sAge = scanner.nextLine();
                if (isDigit(sAge)) {
                    if (checkAge(Integer.parseInt(sAge))) {
                        age = Integer.parseInt(sAge);
                        break;
                    } else {
                        System.out.println("Возраст указан не корректно! Попробуйте еще раз:");
                    }
                } else {
                    System.out.println("Возраст указан не корректно! Попробуйте еще раз:");
                }
            }
            Human newHuman = new Human(name, age);
            if (!humans.contains(newHuman)) {
                humans.add(new Human(name, age));
            }
        }

        try (FileOutputStream fileOutputStream = new FileOutputStream(dataFile);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            for (Human human : humans) {
                objectOutputStream.writeObject(human);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static boolean isDigit(String number){
        try {
            Integer.parseInt(number);
        }
        catch (NumberFormatException e){
            return false;
        }
        return true;
    }


    private static boolean checkAge(int age){
        return age >= 0 && age <= 100;
    }
}