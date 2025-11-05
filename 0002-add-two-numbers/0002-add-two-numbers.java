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
        if(l1 == null)
            return  l2;
        if(l2 == null)
            return l1;

        ListNode head = null;
        ListNode curr = null;
        boolean carry = false;
        while (l1 != null && l2 != null){
            int a = l1.val;
            int b = l2.val;
            int sum = a + b;
            if(carry)
                sum += 1;
            int first = sum/10;
            int second = sum%10;
            if(head == null){
                head = new ListNode(second);
                curr = head;
            }else{
                curr.next = new ListNode(second);
                curr = curr.next;
            }
            carry = first != 0;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null){
            int val = l1.val;
            if(carry)
                val += 1;

            int first = val/10;
            int second = val%10;
            curr.next = new ListNode(second);
            curr = curr.next;
            carry = first != 0;
            l1 = l1.next;
        }


        while (l2 != null){
            int val = l2.val;
            if(carry)
                val += 1;
            int first = val/10;
            int second = val%10;
            curr.next = new ListNode(second);
            curr = curr.next;
            carry = first != 0;
            l2 = l2.next;
        }

        if(carry){
            curr.next = new ListNode(1);
        }
        return head;
    }
}