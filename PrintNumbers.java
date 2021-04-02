/**
 * 17
 * https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
 */

class PrintNumbers {
    public int[] printNumbers(int n) {
        if (n < 0) {
            return null;
        } else if (n == 0) {
            return new int[0];
        }
        int maxNumber = 1;
        while (n > 0) {
            maxNumber = maxNumber * 10;
            n = n - 1;
        }
        int[] intArray = new int[maxNumber - 1];
        for (int i = 0; i < maxNumber - 1; i += 1) {
            intArray[i] = i + 1;
        }
        return intArray;
    }
}