package model;

public class Common {
    /**
     * Checks the string value for null or "" after being stripped of whitespace
     *
     * @param sValue Value to check
     * @return Boolean
     */
    public static boolean isBlank(String sValue) {
        return sValue == null || sValue.length() == 0 || (" \t\n\r".indexOf(sValue.charAt(0)) > -1 && sValue.replaceAll("(^[ \t\n\r]*)|([ \t\n\r]*$)", "").isEmpty());
    }

    /**
     * Checks the string value for null
     *
     * @param sValue Value to check
     * @return Boolean
     */
    public static boolean isBlank(Object sValue) {
        return sValue == null;
    }

    /**
     * Provides a safe way of parsing a string for an Integer without
     * causing the caller too much stress if the string is not actually a number
     *
     * @param value String to convert to a number
     * @return Int Returns 0 if not a number of null
     */
    public static int parseInt(String value) {
        int returnValue = 0;
        if (!isBlank(value)) {
            try {
                returnValue = Integer.parseInt(value);
            }
            catch (Exception e) {
                // Nothing to do
            }
        }
        return returnValue;
    }

    /**
     * Returns true or false if the strings match
     *
     * @param sValue1 String 1 to match
     * @param sValue2 String 2 to match
     * @return boolean
     */
    public static boolean doStringsMatch(String sValue1, String sValue2) {
        return doStringsMatch(sValue1, sValue2, true);
    }

    /**
     * Returns true or false if the strings match
     *
     * @param sValue1         String 1 to match
     * @param sValue2         String 2 to match
     * @param caseInsensitive True if the match is case insensitive
     * @return boolean
     */
    public static boolean doStringsMatch(String sValue1, String sValue2, boolean caseInsensitive) {
        if (sValue1 == null && sValue2 == null) {
            return true;
        }
        else if (sValue1 == null || sValue2 == null) {
            return false;
        }
        else {
            if (caseInsensitive) {
                return sValue1.equalsIgnoreCase(sValue2);
            }
            else {
                return sValue1.equals(sValue2);
            }
        }
    }

}
