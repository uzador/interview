package fiveteen_interview_tasks;

public class ReverseString {
    public static void main(String[] args) {
        final String str = "123456789";
        System.out.println(getReverseString(str));
    }

    private static String getReverseString(final String str) {
        final char[] source = str.toCharArray();
        final int length = source.length;
        final char[] result = new char[length];
        for (int i = 0; i < length; i++) {
            result[i] = source[length - 1 - i];
        }

        return new String(result);
    }
}
