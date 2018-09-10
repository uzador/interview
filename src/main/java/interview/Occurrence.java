package interview;

import java.util.Arrays;

public class Occurrence {
    public static void main(String[] args) {
        int[] array = new int[]{0, 1, 2, 3, 4, 5, 8, 6, 7, 8, 1, 8, 8, 0, 0};
        int number = 8;

        System.out.println("number " + number + " -> " + occurrences(array, number));
    }

    private static int occurrences(int[] array, int number) {
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        int occurrences = 0;

        int idx = Arrays.binarySearch(array, number);

        for (int i = idx; i < array.length; i++) {
            if (array[i] != number) {
                break;
            }

            occurrences++;
        }

        if (idx != 0) {
            for (int i = idx - 1; i == 0; i--) {
                if (array[i] != number) {
                    break;
                }

                occurrences++;
            }
        }

        return occurrences;
    }
}
