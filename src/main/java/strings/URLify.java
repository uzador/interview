package strings;

public class URLify {
    public static void main(String[] args) {
        final String str = "Mr John Smith    ";
        final int len = 13;

        System.out.println(urlifyString(str, len));
    }

    private static String urlifyString(final String str, final int length) {
        final char[] strArr = str.toCharArray();
        int lastIndex = strArr.length - 1;

        for(int i = length - 1; i > 0; i--) {
            if (strArr[i] == ' ') {
                strArr[lastIndex--] = '0';
                strArr[lastIndex--] = '2';
                strArr[lastIndex--] = '%';
            } else {
                strArr[lastIndex--] = strArr[i];
            }
        }

        return new String(strArr);
    }
}
