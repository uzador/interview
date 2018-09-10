package strings;

import java.util.concurrent.ThreadLocalRandom;

public class ZeroMatrix {
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

    public static void zeroOut(final int[][] matrix) {
        final boolean[] rows = new boolean[matrix.length];
        final boolean[] columns = new boolean[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    columns[j] = true;
                }
            }
        }

        zeroOutColumns(columns, matrix);
        zeroOutRows(rows, matrix);
    }

    private static void zeroOutColumns(final boolean[] columns, final int[][] matrix) {
        for (int i = 0; i < matrix[0].length; i++) {
            if (columns[i]) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
    }

    private static void zeroOutRows(final boolean[] rows, final int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            if (rows[i]) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }


        public static void main (String[]args){
            final int[][] matrix = new int[3][4];
            fill(matrix);
            print(matrix);
            System.out.println();
            zeroOut(matrix);
            print(matrix);
        }
    }
