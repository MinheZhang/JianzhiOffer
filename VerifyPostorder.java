/**
 * 33
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/
 */

class VerifyPostorder {
    public boolean verifyPostorder(int[] postorder) {

        if (postorder == null) {
            return false;
        }
        if (postorder.length == 1) {
            return true;
        }

        return helper(postorder, 0, postorder.length - 1);
    }

    private boolean helper(int[] postorder, int start, int end) {

        if (start >= end) {
            return true;
        }

        int root = postorder[end];
        int startRight = -1;

        // Find the first index of right subtree.
        for (int i = start; i < end; i += 1) {
            if (postorder[i] > root) {
                startRight = i;
                break;
            }
        }

        if (startRight == -1) {
            // No right subtree.
            return helper(postorder, start, end - 1);
        } else {
            // Have right subtree.
            for (int i = startRight; i < end; i += 1) {
                if (postorder[i] < root) {
                    return false;
                }
            }
        }
        return helper(postorder, start, startRight - 1) && helper(postorder, startRight, end - 1);
    }
}
