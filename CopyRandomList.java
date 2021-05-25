/*

35
https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/

// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class CopyRandomList {
    public Node copyRandomList(Node head) {

        if (head == null) {
            return null;
        }

        Node sentinel = new Node(-1);

        // key = origin node, value = newly created node.
        Map<Node, Node> oldNewNodeMap = new HashMap<Node, Node>();

        // Scan through the origin list and build next nodes.
        Node oldCurr = head;
        Node newCurr = sentinel;
        while (oldCurr != null) {
            newCurr.next = new Node(oldCurr.val);
            oldNewNodeMap.put(oldCurr, newCurr.next);

            oldCurr = oldCurr.next;
            newCurr = newCurr.next;
        }

        // Scan through the old and new lists and build next nodes.
        oldCurr = head;
        newCurr = sentinel.next;
        Node newRandom;
        while (oldCurr != null) {

            newRandom = oldNewNodeMap.get(oldCurr.random);
            newCurr.random = newRandom;

            oldCurr = oldCurr.next;
            newCurr = newCurr.next;
        }

        return sentinel.next;
    }
}