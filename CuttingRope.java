/**
 * #14-I
 * https://leetcode-cn.com/problems/jian-sheng-zi-lcof/
 */

class CuttingRope {
    public int cuttingRope(int n) {
        if (n < 2) {
            return n;
        }
        int[][] dp = new int[n + 1][n + 1];
        dp[2][2] = 1;
        for (int len = 2; len <= n; len += 1) {
            if (len % 2 == 1) {
                dp[len][2] = (len / 2) * (len / 2 + 1);
            } else {
                dp[len][2] = (len / 2) * (len / 2);
            }
        }
        int optMult = 0;
        for (int len = 3; len <= n; len += 1) {
            for (int m = 3; m <= len; m += 1) {
                int optLastLen = 0;
                optMult = 0;
                for (int lastLen = 1; lastLen <= len - (m - 1); lastLen += 1) {
                    int tempMult = dp[len - lastLen][m - 1] * lastLen;
                    if (optMult < tempMult) {
                        optMult = tempMult;
                        optLastLen = lastLen;
                    }
                }
                dp[len][m] = optMult;
            }
        }
        int result = 0;
        for (int m = 2; m <= n; m += 1) {
            if (dp[n][m] > result) {
                result = dp[n][m];
            }
        }
        return result;
    }
}