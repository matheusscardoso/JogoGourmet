package main.utils;


public class Utils {

    public static boolean StringIsBlank(final CharSequence cs) {
        if (cs == null) return true;
        final int strLen = cs.length();
        if (strLen == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(cs.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
