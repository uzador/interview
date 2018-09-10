package interview;

import java.util.Arrays;

public class DupInArray {
    public static void main(String[] args) {
        int[] array = new int[]{0, 1, 2, 3, 4, 8, 5, 6, 15, 110, 8, 45};
        System.out.println(dup(array));
    }

    private static int dup(int[] array) {
        Arrays.sort(array);
        int idx = 0;

        for (int i = 1; i < array.length ; i++) {
            if (array[i - 1] == array[i]) {
                idx = i;
                break;
            }
        }

        return array[idx];
    }
}
