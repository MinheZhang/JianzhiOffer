/**
 * 
 * 32-ii
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/
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
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> parentQueue = new LinkedList<TreeNode>();
        Queue<TreeNode> childQueue = new LinkedList<TreeNode>();

        parentQueue.offer(root);

        for (int level = 0; !parentQueue.isEmpty(); level += 1) {
            result.add(new ArrayList<Integer>());

            while (!parentQueue.isEmpty()) {
                TreeNode curr = parentQueue.poll();
                // Add children to queue.
                if (curr.left != null) {
                    childQueue.offer(curr.left);
                }
                if (curr.right != null) {
                    childQueue.offer(curr.right);
                }
                // Add element to result.
                result.get(level).add(curr.val);
            }
            Queue<TreeNode> temp = parentQueue;
            parentQueue = childQueue;
            childQueue = temp;
        }

        return result;
    }
}