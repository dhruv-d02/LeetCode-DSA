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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode tempHead = head;
        ListNode fromBeg = head;
        ListNode fromLast = head;
        int size = 1;
        while (tempHead.next  != null){
            size++;
            tempHead = tempHead.next;
        }
        tempHead = head;
        int pos = 1;
        //System.out.println(size);
        while (tempHead != null){
            if(pos == k){
                fromBeg = tempHead;
            }
            if(pos == size-k+1){
                fromLast = tempHead;
            }
            pos++;
            tempHead = tempHead.next;
        }
        int temp = fromLast.val;
        fromLast.val = fromBeg.val;
        fromBeg.val = temp;
        return head;
    }
}