/**
 * 
 * 26
 * https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/
 * 
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class IsSubStructure {
    public boolean isSubStructure(TreeNode A, TreeNode B) {

        if (A == null || B == null) {
            return false;
        }

        Queue<TreeNode> bfsQueue = new LinkedList<TreeNode>();
        bfsQueue.offer(A);
        while (!bfsQueue.isEmpty()) {
            TreeNode curr = bfsQueue.poll();
            if (curr.val == B.val) {
                if (bfs(curr, B)) {
                    return true;
                }
            }
            if (curr.left != null) {
                // Add left child to BFS queue.
                bfsQueue.offer(curr.left);
            }
            if (curr.right != null) {
                // Add right child to BFS queue.
                bfsQueue.offer(curr.right);
            }
        }
        return false;
    }

    private boolean bfs(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null) {
            return false;
        }
        return (A.val == B.val) && bfs(A.left, B.left) && bfs(A.right, B.right);
    }
}