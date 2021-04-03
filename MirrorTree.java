/**
 * 
 * 27
 * https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
 * 
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public TreeNode mirrorTree(TreeNode root) {
        helper(root);
        return root;
    }

    private void helper(TreeNode n) {

        if (n == null) {
            return;
        }

        helper(n.left);
        helper(n.right);

        TreeNode temp = n.left;
        n.left = n.right;
        n.right = temp;
    }
}