import java.util.HashMap;

public class P2RomanToNumber2 {
    static HashMap<String,Integer> romanMap;

    static {
        romanMap = new HashMap<>();
        romanMap.put("I", 1);
        romanMap.put("V", 5);
        romanMap.put("X", 10);
        romanMap.put("L", 50);
        romanMap.put("C", 100);
        romanMap.put("D", 500);
        romanMap.put("M", 1000);
        romanMap.put("IV", 4);
        romanMap.put("IX", 9);
        romanMap.put("XL", 40);
        romanMap.put("XC", 90);
        romanMap.put("CD", 400);
        romanMap.put("CM", 900);
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MCDLXXVI"));
    }

    public static<T> T nvl(T t1, T t2) {
        return t1 == null ? t2 : t1;
    }

    public static int romanToInt(String s) {
        int i=0;
        int sum = 0;
         s = s.toUpperCase();
        while(i < s.length() - 1) {
            String firstChar = s.charAt(i) + "";
            String secondChar = s.charAt(i+1) + "";
            String subStr = firstChar + secondChar;
            if(romanMap.containsKey(subStr)) {
                sum += romanMap.get(subStr);
                i+= 2;
            } else {
                sum += romanMap.get(firstChar);
                i+= 1;
            }
        }
        while(i < s.length()) {
            sum += romanMap.get(s.charAt(i) + "");
            i++;
        }
        return sum;
    }
}
