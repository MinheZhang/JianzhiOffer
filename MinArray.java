/**
 * #11
 */
class MinArray {
    public int minArray(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return -1;
        }
        if (numbers.length == 1) {
            return numbers[0];
        }
        int n = numbers.length;
        for (int i = 0; i < n - 1; i += 1) {
            if (numbers[i] > numbers[i + 1]) {
                return numbers[i + 1];
            }
        }
        return numbers[0];
    }
}