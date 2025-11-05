import java.util.ArrayList;

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
        ArrayList<Integer> vals = new ArrayList<>();
        ListNode curr = head;
        while (curr != null){
            vals.add(curr.val);
            curr = curr.next;
        }

        int l = 1;
        int r = vals.size() - 1;
        boolean changeVal = true;
        curr = head;
        while (l <= r){
            if(changeVal){
                curr.next = new ListNode(vals.get(r));
                r--;
            }else{
                curr.next = new ListNode(vals.get(l));
                l++;
            }
            curr = curr.next;
            changeVal = !changeVal;
        }
    }
}