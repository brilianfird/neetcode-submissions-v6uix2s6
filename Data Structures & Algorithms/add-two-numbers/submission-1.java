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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Addition
        int remain = 0;
        ListNode dummyNode = new ListNode();
        ListNode currNode = dummyNode;

        while (l1 != null || l2 != null) {
            if (l1 != null) remain += l1.val;
            if (l2 != null) remain += l2.val;
            String remainString = String.valueOf(remain);
            
            int newNodeValue = Integer.valueOf(remainString);
            remain = 0;
            System.out.println(remainString);
            if (remainString.length() > 1) {
                newNodeValue = Integer.valueOf(remainString.substring(1, 2));
                remain = Integer.valueOf(remainString.substring(0, 1));
            }
            currNode.next = new ListNode(newNodeValue);
            currNode = currNode.next;

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (remain != 0) {
            currNode.next = new ListNode(remain);
        }

        
        return dummyNode.next;
    }
}
