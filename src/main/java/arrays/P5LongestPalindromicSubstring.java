package arrays;

public class P5LongestPalindromicSubstring {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("ouiuracecariuoiu"));
        System.out.println(longestPalindrome("madamsebastian"));
    }

    public static String longestPalindrome(String s) {
        String finalSubString = "";
        for (int i = 0; i < s.length(); i++) {
            int left = i, right = i;
            String oddSubString = getMaxLengthPalindromeAtIndex(s, left, right);
            String evenSubString = getMaxLengthPalindromeAtIndex(s, left, right+1);

            if(finalSubString.length() < oddSubString.length()) {
                finalSubString = oddSubString;
            }
            if(finalSubString.length() < evenSubString.length()) {
                finalSubString = evenSubString;
            }
        }
        return finalSubString;
    }

    public static String getMaxLengthPalindromeAtIndex(String s, int left, int right) {
        String substring = "";

        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            substring = s.substring(left, right + 1);
            left--;
            right++;
        }
        return substring;
    }
}
