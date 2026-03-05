import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for(int i : nums)
            map.put(i, true);
        
        ListNode prev = null;
        ListNode curr = head;
        
        while (curr != null){
            if(map.get(curr.val) != null){
                if(curr == head){
                    head = head.next;
                    curr = head;
                }else{
                    prev.next = curr.next;
                    curr = curr.next;
                }
            }else{
                prev = curr;
                curr = curr.next;
            }
        }
        return head;
    }
}