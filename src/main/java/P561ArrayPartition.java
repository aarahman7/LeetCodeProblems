import java.util.Arrays;

public class P561ArrayPartition {
    public static void main(String[] args) {
        System.out.println(arrayPairSum(new int[]{6, 2, 6, 5, 1, 2}));
        System.out.println(arrayPairSum(new int[]{2,3,4,5,2,1}));
    }

    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for(int i=0 ; i < nums.length; i = i + 2) {
            sum += nums[i];
        }
        return sum;
    }
}
