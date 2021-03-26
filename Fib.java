class Fib {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        long f0 = 0;
        long f1 = 1;
        long result = 0;
        for (int i = 2; i <= n; i += 1) {
            result = (f0 + f1) % 1000000007;
            f0 = f1 % 1000000007;
            f1 = result % 1000000007;
        }
        result = result % 1000000007;
        return (int)result;
    }
}