import java.util.List;

public class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = null;
        ListNode curr = null;
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }

        while (list1 != null && list2 != null){
            if(list1.val <= list2.val){
                if(head == null){
                    head = new ListNode(list1.val);
                    curr = head;
                }else{
                    curr.next = new ListNode(list1.val);
                    curr = curr.next;
                }
                list1 = list1.next;
            }else{
                if(head == null){
                    head = new ListNode(list2.val);
                    curr = head;
                }else{
                    curr.next = new ListNode(list2.val);
                    curr = curr.next;
                }
                list2 = list2.next;
            }
        }

        while (list1 != null){
            curr.next = new ListNode(list1.val);
            list1 = list1.next;
            curr = curr.next;
        }
        while (list2 != null){
            curr.next = new ListNode(list2.val);
            list2 = list2.next;
            curr = curr.next;
        }

        return head;
    }
}