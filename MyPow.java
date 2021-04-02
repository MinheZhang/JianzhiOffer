/**
 * 16
 * https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/
 */


class MyPow {


    public double myPowMinhe(double x, int n) {
        long longN = n;
        if (x == 1) {
            return 1;
        } else if (x == -1) {
            if (n % 2 == 0) {
                return 1;
            } else {
                return -1;
            }
        }
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            x = 1 / x;
            longN = -longN;
        }
        if (n == -2147483648) {
            return 0;
        }
        double result = 1;
        for (long i = 0; i < longN; i += 1) {
            result *= x;
        }
        return result;
    }

    public double myPow(double x, int n) {
        if (x == 0) {
            if (n == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        long longN = n;
        if (n < 0) {
            x = 1 / x;
            longN = -longN;
        }
        double result = 1;
        while (longN > 0) {
            if ((longN & 1) == 1) {
                result *= x;
            }
            longN >>= 1;
            x *= x;
        }
        return result;
    }
}