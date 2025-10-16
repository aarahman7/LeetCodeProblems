
public class P2932MaximumStrongPairXOR {
    public int maximumStrongPairXor(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                int x = nums[i];
                int y = nums[j];
                if (Math.abs(x - y) <= Math.min(x, y)) {
                    max = Math.max(max, x ^ y);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        P2932MaximumStrongPairXOR p2932MaximumStrongPairXOR = new P2932MaximumStrongPairXOR();
//        System.out.println(p2932MaximumStrongPairXOR.maximumStrongPairXor(new int[]{1,2,3,4,5}));
//        System.out.println(p2932MaximumStrongPairXOR.maximumStrongPairXor(new int[]{10,100}));
        System.out.println(p2932MaximumStrongPairXOR.maximumStrongPairXor(new int[]{1,1,10,3,9}));
    }
}

