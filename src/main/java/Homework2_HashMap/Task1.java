package Homework2_HashMap;

import java.util.*;

public class Task1 {
    public static Map<String, Integer> counter(String text) {
        String[] words = text.split("\\s+");
        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        return map;
    }
}
