import java.util.List;
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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode newHead = null;
        ListNode curr = head;
        ListNode last = null;
        boolean firstTime = true;
        Stack<ListNode> stack = new Stack<>();
        while (curr != null) {
            while (stack.size() < k && curr != null) {
                stack.add(curr);
                curr = curr.next;
            }
            if (stack.size() == k) {
                ListNode ret = reverse(stack, firstTime);
                if (firstTime) {
                    firstTime = false;
                    newHead = ret;
                    last = newHead;
                } else {
                    last.next = ret;
                }
                while (last.next != null) {
                    last = last.next;
                }
                last.next = curr;
            }
        }
        return newHead;
    }

    private ListNode reverse(Stack<ListNode> stack, boolean firstTime) {
        ListNode head = stack.pop();
        ListNode curr = head;
        while (!stack.isEmpty()){
            curr.next = stack.pop();
            curr = curr.next;
        }
        curr.next = null;
        return  head;
    }
}