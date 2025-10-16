public class P2RomanToNumber {
    public static void main(String[] args) {
        System.out.println(romanToInt("MCDLXXVI"));
    }

    public static int romanToInt(String s) {
        s = s.toUpperCase();
        int total = 0;
        for(int i=0; i<s.length(); i++) {
            int currentValue = getValue(s.charAt(i)+"");
            int nextValue = 0;
            if(i+1 < s.length()) {
                nextValue = getValue(s.charAt(i + 1)+"");
            }
            if(currentValue >= nextValue) {
                total += currentValue;
            } else {
                int appliedNegativeValue = applyNegativeValue(s, s.charAt(i) + "", i);
                if(appliedNegativeValue > -1) {
                    total += appliedNegativeValue;
                    i++;
                } else {
                    total += currentValue;
                }
            }
        }
        return total;
    }

    public static int getValue(String s) {
        switch(s) {
            case "I":
                return 1;
            case "V":
                return 5;
            case "X":
                return 10;
            case "L":
                return 50;
            case "C":
                return 100;
            case "D":
                return 500;
            case "M":
                return 1000;
        }
        return 0;
    }

    public static int applyNegativeValue(String allLetters, String currentLetter, int n) {
        if(n + 1 >= allLetters.length()) {
            return getValue(currentLetter);
        }
        String nextLetter = allLetters.charAt(n+1) + "";
        if(currentLetter.equals("I")) {
            if(nextLetter.equals("V")) {
                return 4;
            } else if(nextLetter.equals("X")) {
                return 9;
            }
        }
        else if(currentLetter.equals("X")) {
            if(nextLetter.equals("L")) {
                return 40;
            } else if(nextLetter.equals("C")) {
                return 90;
            }
        }
        else if(currentLetter.equals("C")) {
            if(nextLetter.equals("D")) {
                return 400;
            } else if(nextLetter.equals("M")) {
                return 900;
            }
        }
        return -1;
    }
}
