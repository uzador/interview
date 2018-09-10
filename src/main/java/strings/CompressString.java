package strings;

public class CompressString {
    public static String compress(final String value) {
        final StringBuilder s = new StringBuilder();
        int level = 1;

        for (int i = 1; i < value.length(); i++) {
            if (value.charAt(i - 1) == value.charAt(i)) {
                level++;
                continue;
            }

            s.append(value.charAt(i - 1)).append(level);
            level = 1;
        }

        s.append(value.charAt(value.length() - 1)).append(level);

        return s.length() < value. length() ? s.toString() : value;
    }
}
