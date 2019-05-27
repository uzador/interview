package fiveteen_interview_tasks;

import java.util.stream.IntStream;

public class Fibonacci {
    public static void main(String[] args) {
        IntStream.rangeClosed(1, 10).forEach(i -> {
            System.out.println(Fibonacci.getFibonacciIterat(i));
        });
    }

    public static int getFibonacci(int count) {
        if (count == 1 || count == 2) {
            return 1;
        }

        return getFibonacci(count - 1) + getFibonacci(count - 2);
    }

    public static int getFibonacciIterat(int count) {
        if (count == 1 || count == 2) {
            return 1;
        }

        int f1 = 1, f2 = 1, result = 1;
        for (int i = 3; i <= count; i++) {
            result = f1 + f2;
            f1 = f2;
            f2 = result;
        }

        return result;
    }
}
