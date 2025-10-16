public class P509Fibonacci {
    public static void main(String[] args) {
        P509Fibonacci p509Fibonacci = new P509Fibonacci();
        System.out.println(p509Fibonacci.fib(0));
        System.out.println(p509Fibonacci.fib(2));
        System.out.println(p509Fibonacci.fib(5));
    }

    public int fib(int n) {
        int f1 = 1;
        int f2 = -1;
        int sum = 0;
        for(int i=0; i<=n; i++) {
            sum = f1 + f2;
            f2 = f1;
            f1 = sum;
        }
        return sum;
    }
}
