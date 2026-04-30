/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        ListNode removeNode = head;
        ListNode prev = null;

        int count = 0;

        while (curr != null) {
            if (count >= n) {
                prev = removeNode;
                removeNode = removeNode.next;
            }
            curr = curr.next;
            count++;
        }
        if (prev == null) return head.next;
        prev.next = removeNode.next;
        
        return head;
    }
}
