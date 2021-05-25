/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class TreeToDoublyList {

    private Node pre;
    private Node head;

    public Node treeToDoublyList(Node root) {
        this.pre = null;

        dfs(root);
        this.head.left = this.pre;
        return this.head;
    }

    private void dfs(Node curr) {

        if (curr == null) {
            return;
        }

        dfs(curr.left);
        if (this.pre == null) {
            this.pre = curr;
            this.head = curr;
        } else {
            this.pre.right = curr;
            curr.left = pre;
            this.pre = curr;
        }
        dfs(curr.right);
    }
}