/**
 * 21
 * https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 */

class Solution {
    public int[] exchange(int[] nums) {

        if (nums == null || nums.length <= 1) {
            return nums;
        }

        int start = 0;
        int end = nums.length - 1;
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i += 1) {
            if (nums[i] % 2 == 1) {
                result[start] = nums[i];
                start += 1;
            } else {
                result[end] = nums[i];
                end -= 1;
            }
        }

        return result;
    }
}