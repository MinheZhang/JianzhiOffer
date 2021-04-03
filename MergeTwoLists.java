/**
 * 
 * 25
 * https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/
 * 
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode(-1);
        ListNode curr = sentinel;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                curr.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            curr = curr.next;
        }
        while (l1 != null) {
            curr.next = new ListNode(l1.val);
            curr = curr.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            curr.next = new ListNode(l2.val);
            curr = curr.next;
            l2 = l2.next;
        }
        return sentinel.next;
    }
}