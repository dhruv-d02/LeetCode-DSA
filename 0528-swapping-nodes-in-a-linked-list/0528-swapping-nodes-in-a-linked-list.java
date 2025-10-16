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
        int pos = 1;
        HashMap<Integer, ListNode> map = new HashMap<>();
        while (tempHead  != null){
            map.put(pos, tempHead);
            pos++;
            tempHead = tempHead.next;
        }
        //         for(Map.Entry<Integer, ListNode> e : map.entrySet()){
        //     System.out.println(e.getKey() + "  " + e.getValue().val);
        // }
        ListNode fromBeg = map.get(k);
        ListNode fromLast = map.get(map.size() - k+1);
        // System.out.println(map.size() + "  " + fromBeg.val + "  " + fromLast.val);
        int temp = fromLast.val;
        fromLast.val = fromBeg.val;
        fromBeg.val = temp;
        return head;
    }
}