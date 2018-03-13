package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner =  new Scanner(System.in);
    private static int counter = 0;
    public static void main(String[] args) {
        List<User> users;
        File file = new File("UsersDB");
        if (file.exists()){
            try (FileInputStream fileInputStream = new FileInputStream(file);
                 ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)){
                 users = ((ArrayList<User>) objectInputStream.readObject());
            }
             catch (IOException | ClassNotFoundException e) {
                 e.printStackTrace();
                 System.out.println("Не удалось загрузить базу.");
                 users = new ArrayList<>();
             }
        }
        else {
            users = new ArrayList<>();
        }

        if (users.size() > 0) counter = users.size() - 1;
        else counter = 1;

        while (true){
            String action = scanner.nextLine();
            if (action.equalsIgnoreCase("add")){
                System.out.println("Имя юзера:");
                String name = scanner.nextLine();
                name = name.trim();
                name = Character.toUpperCase(name.charAt(0)) + name.substring(1);
                users.add(new User(name, counter++));
            }
            else if (action.equalsIgnoreCase("remove")){
                System.out.println("Номер пользователя для удаления:");
                while (true){
                    String id = scanner.nextLine();
                    id = id.trim();
                    if (isDigit(id)){
                        users.remove(Integer.parseInt(id));
                        break;
                    }
                }
            }
            else if (action.equalsIgnoreCase("found")){
                System.out.println("Номер искомого пользователя:");
                while (true){
                    String id = scanner.nextLine();
                    id = id.trim();
                    if (isDigit(id)){
                        System.out.println(users.get(Integer.parseInt(id)));
                        break;
                    }
                }
            }
            else if (action.equalsIgnoreCase("exit")){
                saveDB(users);
                System.exit(0);
            }
        }
    }

    private static void saveDB(List<User> users){
        try (FileOutputStream fileOutputStream = new FileOutputStream("UsersDB");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)){
            objectOutputStream.writeObject(users);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    private static boolean isDigit(String number) {
        try {
            Integer.parseInt(number);
        }
        catch (NumberFormatException e){
            return false;
        }
        return true;
    }
}
