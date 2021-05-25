/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    private LinkedList<List<Integer>> ans;
    private int t;

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        this.ans = new LinkedList<List<Integer>>();
        if (root == null) {
            return this.ans;
        }
        this.t = target;
        dfs(new LinkedList<Integer>(), 0, root);
        return this.ans;
    }

    private void dfs(LinkedList<Integer> path, Integer sum, TreeNode curr) {
        // curr reaches the bottom of tree.
        if (isLeaf(curr)) {
            if (curr.val + sum == this.t) {
                // hit!
                List<Integer> hit = (LinkedList<Integer>) path.clone();
                hit.add(curr.val);
                ans.add(hit);
            }
            return;
        }
        // curr is a internal node.
        path.add(curr.val);
        sum += curr.val;
        if (curr.left != null) {
            dfs(path, sum, curr.left);
        }
        if (curr.right != null) {
            dfs(path, sum, curr.right);
        }
        path.removeLast();
        return;
    }

    private boolean isLeaf(TreeNode n) {
        if (n == null) {
            return false;
        } else if (n.left == null && n.right == null) {
            return true;
        } else {
            return false;
        }
    }
}