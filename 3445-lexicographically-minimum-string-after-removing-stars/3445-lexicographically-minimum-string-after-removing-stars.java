import javax.management.ObjectName;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

class Solution {
    public String clearStars(String s) {
        char smallestinLeft = s.charAt(0);
        int index = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                char a = s.charAt(o1);
                char b = s.charAt(o2);
                if(a == b){
                    return  o2 - o1;
                }
                return a - b;
            }
        });
        HashMap<Integer, DoublyLinkedList> map = new HashMap<>();
        DoublyLinkedList current = new DoublyLinkedList(s.charAt(0));
        map.put(0, current);
        pq.offer(0);

        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '*'){
                if(i == 0)
                    continue;
                int idx = pq.poll();
                DoublyLinkedList lastSmall = map.get(idx);
                DoublyLinkedList prev = lastSmall.prev;
                DoublyLinkedList next = lastSmall.next;
                if(prev != null) {
                    prev.next = next;
                    if(next != null)
                        next.prev = prev;
                }else {
                    if(lastSmall.next != null) {
                        lastSmall.next.prev = null;
                    }else{
                        if(current == lastSmall){
                            current = null;
                        }
                    }
                }
                map.remove(idx);
                if(current == lastSmall){
                    if(lastSmall.prev != null)
                        current = lastSmall.prev;
                }
            }else{
                DoublyLinkedList next = new DoublyLinkedList(s.charAt(i), current);
                if(current != null) {
                    current.next = next;
                }
                current = next;
                map.put(i, current);
                pq.offer(i);
            }
        }

        if(current == null)
            return "";
        String ans = current.c + "";

        while (current.prev != null){
            ans = current.prev.c + ans;
            current = current.prev;
        }
        return ans;
    }

    class DoublyLinkedList{
        char c;
        DoublyLinkedList next;
        DoublyLinkedList prev;

        public DoublyLinkedList(char c) {
            this.c = c;
            this.next = null;
            this.prev = null;
        }

        public DoublyLinkedList(char c, DoublyLinkedList prev) {
            this.c = c;
            this.prev = prev;
        }
    }
}