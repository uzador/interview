package strings;

public class OneAway {
    public static void main(String[] args) {
        final String one = "Pal";
        final String away = "sPal";

        System.out.println(isOneAway(one, away));
    }

    public static boolean isOneAway(final String one, final String away) {
        final char[] oneArray = one.toCharArray();
        final char[] awayArray = away.toCharArray();

        if (oneArray.length - awayArray.length == 0) {
            return checkReplace(oneArray, awayArray);
        } else if (oneArray.length - awayArray.length == -1) { //insert
            return oneEditInsert(oneArray, awayArray);
        } else if (oneArray.length - awayArray.length == 1) { //delete
            return oneEditInsert(awayArray, oneArray);
        } else {
            return false;
        }

    }

    private static boolean checkDelete(final char[] one, final char[] away) {
        int shift = 0;
        int lastIndex = away.length;
        for (int i = 0; i < one.length; i++) {
            if (i == lastIndex && shift == 0) {
                return true;
            }

            if (one[i] != away[i - shift]) {
                shift++;
            }
        }

        return shift == 1;
    }

    private static boolean oneEditInsert(final char[] one, final char[] away) {
        int index1 = 0;
        int index2 = 0;
        while(index2 < away.length && index1 < one.length) {
            if (one[index1] != away[index2]) {
                if (index1 != index2) {
                    return false;
                }

                index2++;
            } else {
                index1++;
                index2++;
            }
        }

        return true;
    }

    private static boolean checkReplace(final char[] one, final char[] away) {
        boolean foundDiff = false;
        for (int i = 0; i < one.length; i++) {
            if (one[i] != away[i]) {
                if (foundDiff) {
                    return false;
                }

                foundDiff = true;
            }
        }

        return true;
    }
}
