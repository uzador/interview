package strings;

public class PolindromPermutation {
    public static void main(String[] args) {
        final String str = "Tact Coa";

        System.out.println(isPolindromPermutation(str));
    }

    private static boolean isPolindromPermutation(final String str) {
        final int[] abc = new int[128];
        final char[] strArr = str.toCharArray();

        for(char c: strArr) {
            char charInLow = Character.toLowerCase(c);

            if (charInLow != ' ') {
                abc[charInLow]++;
            }
        }

        boolean isEvenCheckedOnce = false;
        for(int i: abc) {
            if (i % 2 != 0) {
                if (!isEvenCheckedOnce) {
                    isEvenCheckedOnce = true;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
