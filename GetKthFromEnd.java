/**
 * 22
 * 
 * https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 * 
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class GetKthFromEnd {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            if (k == 1) {
                return head;
            } else {
                return null;
            }
        }
        int[] listNodeIndex = new int[1];
        return getKthHelper(head, listNodeIndex, k);
    }

    private ListNode getKthHelper(ListNode n, int[] listNodeIndex, int k) {
        if (n == null) {
            listNodeIndex[0] = 0;
            return null;
        }

        ListNode result = getKthHelper(n.next, listNodeIndex, k);
        listNodeIndex[0] += 1;
        if (listNodeIndex[0] == k) {
            return n;
        } else if (result != null) {
            return result;
        }
        return null;
    }
}