import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class P409LongestPalindromeGreedy {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccccdd"));
        System.out.println(longestPalindrome("a"));
        System.out.println(longestPalindrome("ccc"));
    }

    public static int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        int maxPalindromeLength = 0;
        boolean hasOddChar = false;

        for(int count : map.values()) {
            maxPalindromeLength += (count / 2) * 2;
            if (count % 2 == 1) {
                hasOddChar = true;
            }
        }
        if(hasOddChar) {
            maxPalindromeLength += 1;
        }
        return maxPalindromeLength;
    }
}
