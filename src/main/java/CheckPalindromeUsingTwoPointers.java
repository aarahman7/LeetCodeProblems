public class CheckPalindromeUsingTwoPointers {
    public static void main(String[] args) {
        System.out.println(checkPalindrome("MADAM"));
        System.out.println(checkPalindrome("MADAMME"));
    }

    public static boolean checkPalindrome(String s) {
        boolean flag = true;
        for(int i=0; i < s.length()/2; i++) {
            int j = s.length() - i - 1;
            if(s.charAt(i) != s.charAt(j)) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
