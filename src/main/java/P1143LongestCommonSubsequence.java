import java.util.Arrays;

public class P1143LongestCommonSubsequence {
    public static void main(String[] args) {
        String text1 = "bsbininm", text2 = "jmjkbkjkv";
        System.out.println(new P1143LongestCommonSubsequence().longestCommonSubsequenceArray(text1, text2));
//        System.out.println(new P1143LongestCommonSubsequence().longestCommonSubsequenceUsingRecursion(text1, text2));
    }

    public int longestCommonSubsequenceUsingRecursion(String text1, String text2) {
        return lcs1(0,0,text1, text2);
    }

    public int lcs1(int i, int j, String text1, String text2) {
        if (text1.length() == i || text2.length() == j) {
            return 0;
        }
        if (text1.charAt(i) == text2.charAt(j)) {
            return 1 + lcs1(i+1, j+1, text1, text2);
        }
        return Math.max(lcs1(i+1, j, text1, text2), lcs1(i, j+1, text1, text2));
    }

    public int longestCommonSubsequenceArray(String text1, String text2) {
        int[][] arr = new int[text1.length() + 1][text2.length() + 1];
        Arrays.fill(arr[0], 0);
        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = 0;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[i].length; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    arr[i][j] = 1 + arr[i - 1][j - 1];
                } else {
                    arr[i][j] = Math.max(arr[i - 1][j], arr[i][j - 1]);
                }
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
        return arr[arr.length - 1][arr[0].length - 1];
    }

    public int lcs(int i, int j, Integer[][] arr, String text1, String text2) {
        if (text1.length() == i || text2.length() == j) {
            return 0;
        }

        if(arr[i][j] != null) {
            return arr[i][j];
        }
        if (text1.charAt(i) == text2.charAt(j)) {
            arr[i][j] = 1 + lcs(i + 1, j + 1, arr, text1, text2);
        }
        arr[i][j] = Math.max(lcs(i + 1, j, arr, text1, text2), lcs(i, j + 1,arr, text1, text2));
        return arr[i][j];
    }
}