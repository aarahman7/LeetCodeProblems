package arrays;

public class P5LongestPalindromicSubstring {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("ouiuracecariuoiu"));
        System.out.println(longestPalindrome("madamsebastian"));
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        int maxLen = 0;
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            // Check for odd-length palindromes (center is a single character)
            int len1 = expandAroundCenter(s, i, i);
            // Check for even-length palindromes (center is between two characters)
            int len2 = expandAroundCenter(s, i, i + 1);

            int len = Math.max(len1, len2);
            if (len > maxLen) {
                maxLen = len;
                start = i - (len - 1) / 2;
            }
        }

        return s.substring(start, start + maxLen);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // Return the length of the palindrome
        return right - left - 1;
    }

    public static String longestPalindrome2(String s) {
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
