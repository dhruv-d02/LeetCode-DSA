/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (slow != null && fast != null){
            slow=slow.next;
            if(fast.next == null) break;
            else{
                if(fast.next.next != null){
                    fast = fast.next.next;
                }else{
                    break;
                }
            }
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
}