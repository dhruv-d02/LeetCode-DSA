import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

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
    public int pairSum(ListNode head) {
        Stack<ListNode> st = new Stack<>();
        ListNode slow = head;
        ListNode fast = head;
        int maxSum = Integer.MIN_VALUE;
        while (fast != null ){
            st.push(slow);
            slow = slow.next;
            fast = fast.next.next;
        }

        while (slow != null){
            ListNode twin = st.pop();
            maxSum = Math.max(maxSum, twin.val + slow.val);
            slow = slow.next;
        }

        return maxSum;
    }
}