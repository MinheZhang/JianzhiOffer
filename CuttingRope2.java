/**
 * #14-II
 * https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof/
 */

class CuttingRope2 {
    public int cuttingRope(int n) {
        if (n == 2) {
            return 1;
        } else if (n == 3) {
            return 2;
        }
        long result = 1;
        while (n > 4) {
            result *= 3;
            result = result % 1000000007;
            n -= 3;
        }
        result *= n;
        result = result % 1000000007;

        return (int)result;
    }
}