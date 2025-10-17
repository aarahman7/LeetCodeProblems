import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class ValidParenthesis {

    public static void main(String[] args) {
        System.out.println(isParenthesisValid("{}()[]"));
        System.out.println(isParenthesisValid("{[({()[][]{()}})]}"));
        System.out.println(isParenthesisValid("{[({()[][]{(})})]}"));
    }

    static List<Character> leftBrackets = Arrays.asList('(','{','[');
    static List<Character> rightBrackets = Arrays.asList(')',']','}');
    static Map<Character, Character> mappedBrackets = Map.of('}','{',
            ')','(',
            ']','[');

    public static boolean isParenthesisValid(String str) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i < str.length(); i++) {
            char currentChar = str.charAt(i);

            if(leftBrackets.contains(currentChar)) {
                stack.push(currentChar);
            } else if (rightBrackets.contains(currentChar)) {
                char lastCharInStack = stack.pop();
                char expectedChar = mappedBrackets.get(currentChar);
                if(lastCharInStack != expectedChar) {
                    return false;
                }
            } else {
                throw new RuntimeException("Invalid character : " + currentChar);
            }
        }
        return stack.isEmpty();
    }
}
