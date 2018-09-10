package interview;

import java.util.stream.IntStream;

public class FizzBuzz {
    public static void main(String[] args) {
        IntStream.range(1, 101)
                .mapToObj(value -> {
                    boolean fizzCheck = false;
                    boolean buzzCheck = false;

                    if (value % 3 == 0) {
                        fizzCheck = true;
                    }

                    if (value % 5 == 0) {
                        buzzCheck = true;
                    }

                    if (fizzCheck && buzzCheck) {
                        return "FizzBuzz";
                    } else if (fizzCheck) {
                        return "Fizz";
                    } else if (buzzCheck) {
                        return "Buzz";
                    }

                    return Integer.toString(value);
                })
                .forEach(System.out::println);
    }

//    public static void main(String[] args) {
//        int length = 100;
//        for (int i = 1; i <= length; i++) {
//            if (i % 3 == 0 && i % 5 == 0) {
//                System.out.println("fizzbuzz");
//            } else if (i % 3 == 0) {
//                System.out.println("fizz");
//            } else if (i % 5 == 0) {
//                System.out.println("buzz");
//            } else {
//                System.out.println(i);
//            }
//        }
//    }
}
