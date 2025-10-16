import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P1876SubstringOfSize3 {
    public static void main(String[] args) {
        String s = "xyzzza";
        System.out.println(substringOfSize2(s,3));
    }

    public static List<String> substringOfSize(String s, int length) {
        List<String> list = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            if (map.containsKey(currentChar) && map.get(currentChar) >= left) {
                left = map.get(currentChar) + 1;
            }
            map.put(currentChar, right);
            if (right - left + 1 == length) {
                list.add(s.substring(left, right + 1));
                left++;
            }
        }
        return list;
    }

    public static List<String> substringOfSize2(String s, int maxLength) {
        List<String> validStr = new ArrayList<>();
        int left = 0;
        for(int right=0; right<s.length(); right++) {
            int visitedCharIndex = s.indexOf(s.charAt(right), left); // -1, 0
            //if(visitedCharIndex != -1 && visitedCharIndex < right) {
            if(visitedCharIndex != right) {
                left = visitedCharIndex + 1;
            }
            if(right - left + 1 == maxLength) {
                validStr.add(s.substring(left,right+1));
                left++;
            }
        }
        return validStr;
    }
}
