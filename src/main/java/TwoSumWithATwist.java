import java.util.Arrays;

public class TwoSumWithATwist {
    public static void main(String[] args) {
        /**
         * We will have list of loan amount. I have got some amount in hand now.
         * I need to decide which 2 loan amounts that I can pay off with this amount.
         * Remember it should not go beyond the target value not even by $1.
         * Also, I am ready to payoff only 2 loans, not 3 not 1. Only 2.
         */
        int[] loanAmounts = {40000, 20000, 30000, 49999, 10000};
        int target = 90000;
        int minDifference = Integer.MAX_VALUE;

        Arrays.sort(loanAmounts);
        int left = 0, right = loanAmounts.length - 1;
        int finalLeft = 0, finalRight = 0;

        while(left < right) {
            int summedAmount = loanAmounts[left] + loanAmounts[right];
            System.out.println("left : " + left + " right : " + right + " summedAmount : " + summedAmount);

            int currentMinDiff = target - summedAmount;
            if(currentMinDiff >= 0 && currentMinDiff < minDifference) {
                minDifference = currentMinDiff;
                finalLeft = left;
                finalRight = right;
            }

            if (summedAmount <= target) {
                System.out.println("summedAmount < target, left index " + left + " incremented");
                left++;
            } else {
                System.out.println("summedAmount > target, right index " + right + " decremented");
                right--;
            }
        }

        if(loanAmounts[finalRight] + loanAmounts[finalLeft] <= target) {
            System.out.println("Closest loan amount payable is : " + loanAmounts[finalLeft] + " and " + loanAmounts[finalRight] + " with total amount " + (loanAmounts[finalRight] + loanAmounts[finalLeft]));
        } else {
            System.out.println("2 Loan amount can't be paid.");
        }
    }
}
