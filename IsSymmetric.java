/**
 * 
 * 28
 * https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/
 * 
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        }

        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode left, TreeNode right) {

        if (left == null && right == null) {
            return true;
        } else if (left != null && right != null) {
            // Compare value and recursive call
            return left.val == right.val 
                && helper(left.left, right.right)
                && helper(left.right, right.left);
        } else {
            return false;
        }
    }
}
