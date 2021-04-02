/**
 * 
 * 18
 * 
 * https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 * 
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class DeleteNode {
    public ListNode deleteNode(ListNode head, int val) {

        ListNode sentinel = new ListNode(-1);
        sentinel.next = head;

        while (sentinel.next != null) {
            if (sentinel.next.val == val) {
                sentinel.next = sentinel.next.next;
            } else {
                break;
            }
        }

        ListNode prev = sentinel;
        ListNode curr = sentinel.next;

        while (curr != null) {
            if (curr.val == val) {
                curr = curr.next;
                prev.next = curr;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }

        return sentinel.next;
    }
}