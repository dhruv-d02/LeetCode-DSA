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
        int size = 0;
        ListNode curr = head;
        while (curr != null){
            size++;
            curr = curr.next;
        }

        if(size == 1 && n== 1){
            return null;
        }
        
        int pos = 0;
        curr = head;
        ListNode prev = null;
        while (pos < size - n){
            prev = curr;
            curr = curr.next;
            pos++;
        }
        if(prev == null){
            return curr.next;
        }else{
            prev.next = curr.next;
        }

        return head;

    }
}