/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        StringBuffer stringBuffer = new StringBuffer("[");
        Queue<TreeNode> task = new LinkedList<>();
        task.add(root);
        while (!task.isEmpty()) {
            TreeNode curr = task.poll();
            if (curr == null) {
                stringBuffer.append("null,");
            } else {
                stringBuffer.append(curr.val + ",");
                task.add(curr.left);
                task.add(curr.right);
            }
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    public TreeNode deserialize(String data) {
        if (data == null || data.equals("[]") || data.equals("[null]")) {
            return null;
        }
        String[] vals = data.substring(1, data.length() - 1).split(",");
        TreeNode[] nodes = new TreeNode[vals.length];
        TreeNode curr = null;
        int nullNum = 0;
        for (int i = 0; i < vals.length; i += 1) {
            if (!vals[i].equals("null")) {
                if (nodes[i] == null) {
                    nodes[i] = new TreeNode(Integer.parseInt(vals[i]));
                }
                curr = nodes[i];
                int leftIndex = 2 * (i - nullNum) + 1;
                int rightIndex = 2 * (i - nullNum) + 2;
                if (leftIndex < vals.length && !vals[leftIndex].equals("null")) {
                    curr.left = new TreeNode(Integer.parseInt(vals[leftIndex]));
                    nodes[leftIndex] = curr.left;
                }
                if (rightIndex < vals.length && !vals[rightIndex].equals("null")) {
                    curr.right = new TreeNode(Integer.parseInt(vals[rightIndex]));
                    nodes[rightIndex] = curr.right;
                }
            } else {
                nullNum += 1;
            }
        }
        return nodes[0];
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));