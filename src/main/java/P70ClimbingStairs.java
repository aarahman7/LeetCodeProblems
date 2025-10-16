public class P70ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(new P70ClimbingStairs().climbStairs(20));
    }

    /**
     * 1 = {1} -> 1
     * 2 = {11,2} -> 2
     * 3 = {111,12,21} -> 3
     * 4 = {1111, 112, 121, 211, 22} -> 5
     * 5 = {11111,1112, 1121, 1211, 2111, 122, 212, 221} -? 8
     */

    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int secondPrev = 1;
        int prev = 2;
        int curr = 0;
        for (int i = 3; i <= n; i++) {
            curr = secondPrev + prev;
            secondPrev = prev;
            prev = curr;
        }
        return curr;
    }
}
