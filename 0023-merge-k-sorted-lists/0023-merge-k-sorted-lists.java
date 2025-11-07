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
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> set = new ArrayList<Integer>();
        for(int i=0; i<lists.length; i++){
            ListNode head = lists[i];
            while(head != null){
                set.add(head.val);
                head = head.next;
            }
        }
        Collections.sort(set);
        ListNode ret = new ListNode(-1);
        ListNode temp = ret;

        for(int val : set){
            ListNode x = new ListNode(val);
            temp.next = x;
            temp = temp.next;
            // System.out.println(val + "   "+ temp.val);
        }

        return ret.next;

    }
}