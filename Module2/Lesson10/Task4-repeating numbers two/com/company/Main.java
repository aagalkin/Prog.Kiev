package com.company;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        String input = scanner.nextLine();
        for (String s : input.split(",")){
            s = s.trim();
            if (isDigit(s)){
                set.add(Integer.parseInt(s));
            }
        }
        for (Integer intg : set){
            System.out.print(intg + " ");
        }
    }

    private static boolean isDigit(String s){
        try {
            Integer.parseInt(s);
        }
        catch (NumberFormatException e){
            return false;
        }
        return true;
    }
}
