package strings;

public class StringRotation {
    public static boolean isSubstring(final String sub, final String str) {
        return str.contains(sub);
    }

    public static boolean isRotation(final String str, final String rotation) {
        if (str.length() != rotation.length()) {
            return false;
        }


        return isSubstring(rotation, str + str);
    }
}
