import java.util.TreeSet;

public class P121BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        System.out.println(new P121BestTimeToBuyAndSellStock().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(new P121BestTimeToBuyAndSellStock().maxProfit(new int[]{7, 6, 4, 3, 1}));
        System.out.println(new P121BestTimeToBuyAndSellStock().maxProfit(new int[]{2,4,1}));
    }

    public int maxProfit(int[] prices) {
        TreeSet<Integer> pricesTree = new TreeSet<Integer>();
        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price < minValue) {
                if(maxValue != Integer.MIN_VALUE) {
                    pricesTree.add(maxValue - minValue);
                }
                minValue = price;
                maxValue = Integer.MIN_VALUE;
            } else if (price > maxValue) {
                maxValue = price;
            }
        }
        if(maxValue != Integer.MIN_VALUE) {
            pricesTree.add(maxValue - minValue);
        }
        if(pricesTree.isEmpty()) {
            return 0;
        } else {
            return pricesTree.last();
        }
    }
}
