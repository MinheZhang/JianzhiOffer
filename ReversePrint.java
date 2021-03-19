/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class ReversePrint {

    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        return recursiveBuild(head, 1);
    }

    private int[] recursiveBuild(ListNode node, int n) {

        int[] result = null;

        // Base case
        if (node.next == null) {
            result = new int[n];
        } else {
            result = recursiveBuild(node.next, n + 1);
        }
        result[result.length - n] = node.val;
        return result;
    }
}