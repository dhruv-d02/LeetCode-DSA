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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0)
            return head;
        int len = 0;
        ListNode curr = head;
        while (curr != null){
            len++;
            curr = curr.next;
        }
        if(k%len == 0)
            return head;
        k = k%len;
        ListNode prev = null;
        curr = head;
        for (int i = 0; i < len-k; i++) {
            prev = curr;
            curr = curr.next;
        }
        prev.next = null;
        ListNode newHead = curr;
        while (curr.next != null)
            curr = curr.next;
        curr.next = head;
        return newHead;
    }
}