package strings;

import java.util.Arrays;

public class CheckPermutation {
    public static void main(String[] args) {
        String first = "Heltlo15";
        String second = "51eolHlt";

        System.out.println(isPermutation(first, second));
        System.out.println(isPermutation2(first, second));
    }

    private static boolean isPermutation(String first, String second) {
        if (first.length() == second.length()) {
            char[] array1 = first.toCharArray();
            char[] array2 = second.toCharArray();

            Arrays.sort(array1);
            Arrays.sort(array2);

            return Arrays.equals(array1, array2);
        }

        return false;
    }

    private static boolean isPermutation2(String first, String second) {
        if (first.length() == second.length()) {
            int[] count = new int[128];

            for (int i = 0; i < first.length(); i++) {
                char c = first.charAt(i);
                count[c]++;
            }

            for (int i = 0; i < second.length(); i++) {
                int c = (int) second.charAt(i);
                count[c]--;

                if (count[c] < 0) {
                    return false;
                }
            }

//            for (int zero : count) {
//                if (zero != 0) {
//                    return false;
//                }
//            }

            return true;
        }

        return false;
    }
}
