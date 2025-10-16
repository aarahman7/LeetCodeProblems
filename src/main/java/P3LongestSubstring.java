import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class P3LongestSubstring {
    public static void main(String[] args) {
        System.out.println(new P3LongestSubstring().lengthOfLongestSubstring4("abba"));
    }

    public int lengthOfLongestSubstring1(String s) {
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            StringBuilder currentSubstring = new StringBuilder();
            for (int j = i; j < s.length(); j++) {
                if (currentSubstring.indexOf(s.charAt(j) + "") != -1) {
                    break;
                }
                currentSubstring.append(s.charAt(j));
                maxLength = Math.max(currentSubstring.length(), maxLength);
            }
        }
        return maxLength;
    }

    public int lengthOfLongestSubstring2(String s) {
        HashMap<Character, Integer> visitedCharMap = new HashMap<>();
        int left = 0, right = 0;
        int maxLength = 0;
        String maxLengthStr = "";
        for (right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            Integer currentCharPrevIndex = visitedCharMap.get(currentChar);
            if (visitedCharMap.containsKey(currentChar) && currentCharPrevIndex != null && currentCharPrevIndex >= left) {
                left = currentCharPrevIndex + 1;
            }
            visitedCharMap.put(currentChar, right);
            if (maxLength < right - left + 1) {
                maxLength = right - left + 1;
                maxLengthStr = IntStream.range(left, right + 1).mapToObj(i -> s.charAt(i) + "").collect(Collectors.joining(""));
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        System.out.println(maxLengthStr);
        return maxLength;
    }

    /*
    1. create a loop to traverse the complete length.
    2. loop index denotes the right pointer.
    3. HashMap<Character, Integer> will have character and its index.
    4. If a character already available, make the left pointer to currentChar index + 1;
     */

    public int lengthOfLongestSubstring3(String s) {
        int left = 0, right = 0;
        int maxLength = 0;
        String maxLengthStr = null;
        HashMap<Character, Integer> map = new HashMap<>();
        for (right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            if (map.containsKey(currentChar) && map.get(currentChar) >= left) {
                left = map.get(currentChar) + 1;
            }
            map.put(currentChar, right);
            if (maxLength < right - left + 1) {
                maxLength = right - left + 1;
                maxLengthStr = IntStream.range(left, right + 1).mapToObj(i -> s.charAt(i) + "").collect(Collectors.joining(""));
            }
        }
        System.out.println(maxLengthStr);
        return maxLength;
    }

    public int lengthOfLongestSubstring4(String s) {
        int left = 0;
        int maxLength = 0;
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            int index = s.indexOf(currentChar, left);
            if (index != right) {
                left = index + 1;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }


}
