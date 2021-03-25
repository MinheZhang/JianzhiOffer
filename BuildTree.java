/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BuildTree {

    private Map<Integer, Integer> indexMap;

    private TreeNode helper(int[] preorder, int preStart, int preEnd,
        int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }
        int inRootIndex = indexMap.get(rootVal);

        int leftSize = inRootIndex - inStart;

        int leftPreStart = preStart + 1;
        int leftPreEnd = leftPreStart + leftSize - 1;
        int leftInStart = inStart;
        int leftInEnd = inRootIndex - 1;

        int rightPreStart = leftPreEnd + 1;
        int rightPreEnd = preEnd;
        int rightInStart = inRootIndex + 1;
        int rightInEnd = inEnd;

        root.left = helper(preorder, leftPreStart, leftPreEnd, inorder, leftInStart, leftInEnd);
        root.right = helper(preorder, rightPreStart, rightPreEnd, inorder, rightInStart, rightInEnd);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder == null || inorder == null) {
            return null;
        }

        int n = preorder.length;
        if (n != inorder.length) {
            return null;
        }
    
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i += 1) {
            indexMap.put(inorder[i], i);
        }
        return helper(preorder, 0, n - 1, inorder, 0, n - 1); 
    }
}