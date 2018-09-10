package strings;

import java.util.concurrent.ThreadLocalRandom;

public class RotateMatrix {
    public static boolean rotate(final int[][] matrix) {
        if (matrix.length == 0 || matrix.length != matrix[0].length) {
            return false;
        }

        int n = matrix.length;
        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;

            for (int i = first; i < last; i++) {
                int offset = i - first;

                int top = matrix[first][i];

                matrix[first][i] = matrix[last - offset][first];

                matrix[last - offset][first] = matrix[last][last - offset];

                matrix[last][last - offset] = matrix[i][last];

                matrix[i][last] = top;
            }
        }

        return true;
    }

    public static void fill(final int[][] matrix) {
        final int min = 0;
        final int max = matrix[0].length;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = ThreadLocalRandom.current().nextInt(min, max);
            }
        }
    }

    public static void print(final int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(" " + matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int len = 3;
        final int[][] matrix = new int[len][len];
        fill(matrix);
        print(matrix);
        System.out.println();
        rotate(matrix);
        print(matrix);
    }
}
