import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class FibonacciSeriesUsingDP {

    static Integer[] memo;
    static AtomicInteger callCount = new AtomicInteger();

    public static void main(String[] args) {
        int n = 20;
        memo = new Integer[n+1];
        System.out.println(fibonacciWithMemoisation(n));
        System.out.println(fibonacci(n));
        System.out.println(fibonacciUsingTabulation(n));
    }

    public static int fibonacci(int n) {
        System.out.println("fibonacci called " + callCount.incrementAndGet() + " with " + n);
        if (n <= 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static int fibonacciWithMemoisation(int n) {
        System.out.println("fibonacci called " + callCount.incrementAndGet() + " with " + n);
        if(memo[n] != null) {
            return memo[n];
        }

        if(n == 0 || n == 1) {
            memo[0] = 1;
            memo[1] = 1;
            return memo[n];
        }

        memo[n] = fibonacciWithMemoisation(n - 1) + fibonacciWithMemoisation(n - 2);
        return memo[n];
    }

    public static int fibonacciUsingTabulation(int n) {
        int[] arr = new int[n+1];
        arr[0] = 1;
        arr[1] = 1;

        for(int i=2; i<=n; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        System.out.println("Array table : " + Arrays.asList(arr));
        return arr[n];
    }
}
