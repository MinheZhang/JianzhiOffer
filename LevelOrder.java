/**
 * 
 * 32-i
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
 * 
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class LevelOrder {
    public int[] levelOrder(TreeNode root) {

        if (root == null) {
            return new int[0];
        }

        int[] result = new int[2000];
        int index = 0;

        Queue<TreeNode> bfsQueue = new LinkedList<TreeNode>();
        bfsQueue.offer(root);

        while (!bfsQueue.isEmpty()) {
            TreeNode curr = bfsQueue.poll();
            result[index] = curr.val;
            index += 1;
            if (curr.left != null) {
                bfsQueue.offer(curr.left);
            }
            if (curr.right != null) {
                bfsQueue.offer(curr.right);
            }
        }

        return Arrays.copyOfRange(result, 0, index);
    }
}
