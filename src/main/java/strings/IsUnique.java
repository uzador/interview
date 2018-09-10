package strings;

import java.util.HashMap;
import java.util.Map;

public class IsUnique {
    public static void main(String[] args) {
        String str = "abcdefghijklmnopqrstuvwxyz";
        boolean unique = isUniqueString(str);

        System.out.println(unique);
    }

    private static boolean isUniqueString(String str) {
        Map<Character, Integer> alphabet = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char symbol = str.charAt(i);
            Integer count = alphabet.get(Character.toLowerCase(symbol));
            if (count == null) {
                alphabet.put(symbol, 1);
            } else {
                return false;
            }
        }

        return true;
    }
}