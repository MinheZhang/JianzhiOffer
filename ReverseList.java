/**
 * 
 * 24
 * https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 * 
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode tail =  helper(head.next, head);
        head.next = null;
        return tail;
    }

    private ListNode helper(ListNode curr, ListNode prev) {
        if (curr.next == null) {
            curr.next = prev;
            return curr;
        }
        ListNode tail =  helper(curr.next, curr);
        curr.next = prev;
        return tail;
    }
}