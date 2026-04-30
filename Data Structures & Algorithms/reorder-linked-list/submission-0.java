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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode list2 = slow.next;
        slow.next = null;
    
        ListNode list1 = head;

        ListNode prev = null;
        ListNode curr = list2;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        list2 = prev;

        
        int count = 1;
        ListNode result = new ListNode(0);
        curr = result;
        while (list1 != null && list2 != null) {
            if (count % 2 == 1) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
            count++;
        }
        
        curr.next = list1 == null ? list2 : list1;
        head = result.next;
    }
}
