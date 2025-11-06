package backtrack;

import java.util.ArrayList;
import java.util.List;

public class P78Subsets {
    public static void main(String[] args) {
        System.out.println(findSubsetsUsingBacktrack(new int[]{1, 2, 3}));
    }

    public static List<List<Integer>> findSubsetsUsingBacktrack(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), 0, nums);
        return result;
    }

    public static void backtrack(List<List<Integer>> result, List<Integer> temp, int start, int[] nums) {
        result.add(new ArrayList<>(temp));

        for(int i = start; i < nums.length; i++) {
            temp.add(nums[i]);

            backtrack(result, temp, i+1, nums);

            temp.remove(temp.size() - 1);
        }
    }

    public static List<List<Integer>> findSubsetsUsingBinary(int[] nums) {
        int maxSize = (int) Math.pow(2, nums.length);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < maxSize; i++) {
            String binary = getBinaryString(i, nums.length);
            List<Integer> subsetForIndex = mapBinary(binary, nums);
            result.add(subsetForIndex);
        }
        return result;
    }

    public static String getBinaryString(int num, int arrLength) {
        StringBuilder binary = new StringBuilder(Integer.toBinaryString(num));
        int binaryLength = binary.length();
        for (int i = 0; i < arrLength - binaryLength; i++) {
            binary.insert(0, "0");
        }
        return binary.toString();
    }

    public static List<Integer> mapBinary(String binary, int[] nums) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                list.add(nums[i]);
            }
        }
        return list;
    }
}