class FrogStep {
    public int numWays(int n) {
        if (n <= 1) {
            return 1;
        }
        int i0 = 1;
        int i1 = 1;
        int result = 0;
        for (int i = 2; i <= n; i += 1) {
            result = (i0 + i1) % 1000000007;
            i0 = i1;
            i1 = result;
        }
        return result;
    }
}