public class P14LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        String finalStr = "";
        if (strs.length == 0) {
            return finalStr;
        }
        if (strs.length == 1) {
            return strs[0];
        }

        int minLength = strs[0].length();
        for(int i = 1; i < strs.length; i++) {
            minLength = Math.min(minLength, strs[i].length());
        }

        for(int i = 0; i < minLength; i++) {
            char currentChar = strs[0].charAt(i);
            for(int j = 1; j < strs.length; j++) {
                if (currentChar != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0].substring(0, minLength);
    }

    public static void main(String... arg) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
        System.out.println(longestCommonPrefix(new String[]{"ahamed", "abdul", "aalim"}));
        System.out.println(longestCommonPrefix(new String[]{""}));
        System.out.println(longestCommonPrefix(new String[]{"", "", ""}));
        System.out.println(longestCommonPrefix(new String[]{"", "b"}));
    }
}
