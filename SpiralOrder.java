/**
 * 29
 * https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/s
 */

class SpiralOrder {

    public int[] spiralOrder(int[][] matrix) {

        if (matrix == null) {
            return null;
        }

        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int[] spiral = new int[m * n];

        int index = 0;
        int i = 0;
        int j = 0;
        int right = n - 1;
        int down = m - 1;
        int left = 0;
        int top = 1;

        while (index < m * n) {

            // From top left to top right.

            for (int k = j; k <= right; k += 1) {
                spiral[index] = matrix[i][k];
                index += 1;
            }
            j = right;
            i += 1;

            if (i > down) {
                break;
            }

            // From top right to bottom right.
            for (int k = i; k <= down; k += 1) {
                spiral[index] = matrix[k][j];
                index += 1;
            }
            i = down;
            j -= 1;

            if (j < left) {
                break;
            }

            // From bottom right to bottom left.
            for (int k = j; k >= left; k -= 1) {
                spiral[index] = matrix[i][k];
                index += 1;
            }
            j = left;
            i -= 1;

            if (i < top) {
                break;
            }

            // From bottom left to top left.
            for (int k = i; k >= top; k -= 1) {
                spiral[index] = matrix[k][j];
                index += 1;
            }
            i = top;
            j += 1;

            if (j > right) {
                break;
            }

            right -= 1;
            down -= 1;
            left += 1;
            top += 1;
        }

        return spiral;
    }
}