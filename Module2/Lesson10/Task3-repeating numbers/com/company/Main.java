package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Integer[] arr  = {2, 5, 3, 6, 5, 5, 2};
        Arrays.sort(arr);

        Map<Integer, Integer> map = new HashMap<>();

        for (Integer i : arr){
            map.merge(i, 1, (a, b) -> a + b);
        }

        for (Integer i : map.keySet()){
            System.out.println("Число " + i + " повторяется " + map.get(i) + " раз(а).");
        }
    }
}
