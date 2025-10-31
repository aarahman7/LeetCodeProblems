package arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P3289TwoSneakyNumbersOfDigitVille {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getSneakyNumbers(new int[]{0, 3, 2, 1, 3, 2})));
    }

    public static int[] getSneakyNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int[] sneakyNums = new int[2];
        int sneakyNumsIndex = 0;
        for(int i=0; i<nums.length; i++) {
            if(!set.add(nums[i])) {
                sneakyNums[sneakyNumsIndex++] = nums[i];
            }
        }
        return sneakyNums;
    }
}
