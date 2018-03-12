package com.company;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Map<String, String> vocabulary_RusToEn;
        File file = new File("Vocabulary");
        if (file.exists()){
            try (FileInputStream fileInputStream = new FileInputStream(file);
                 ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)){
                vocabulary_RusToEn = ((HashMap<String, String>)objectInputStream.readObject());
            }
            catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                return;
            }
        }
        else {
            vocabulary_RusToEn = new HashMap<>();
            vocabulary_RusToEn.put("слово", "word");
            vocabulary_RusToEn.put("программа", "program");
            vocabulary_RusToEn.put("горшок", "pot");
            //...
        }
        System.out.println("Введите слово, которое нужно перевести, либо \"выход\" для выхода из программы:");
        while (true){
            String word = scanner.nextLine();
            if (word.equalsIgnoreCase("выход")){
                save(vocabulary_RusToEn);
                System.exit(0);
            }
            String result = vocabulary_RusToEn.get(word);
            if (result != null) {
                System.out.println(result);
            }
            else {
                System.out.println("Такого слова нет в словаре, предложите свой вариант перевода:");
                vocabulary_RusToEn.put(word, scanner.nextLine());
                System.out.println("Перевод добавлен.");
            }
        }
    }

    private static void save(Map<String, String> vocabulary){
        try (FileOutputStream fileOutputStream = new FileOutputStream("Vocabulary");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)){
            objectOutputStream.writeObject(vocabulary);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
