import java.util.*;

public class P1TwoNumbers {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
    }

    public static int[] twoSum(int[] num, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<num.length; i++) {
            int currentValue = num[i];
            int remainingValue = target - currentValue;
            if(map.get(currentValue) != null) {
                return new int[] {map.get(currentValue), i};
            } else {
                map.put(remainingValue, i);
            }
        }
        return new int[0];
    }
}
