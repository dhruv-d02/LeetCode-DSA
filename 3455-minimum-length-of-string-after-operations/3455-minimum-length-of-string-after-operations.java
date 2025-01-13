import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public int minimumLength(String s) {
        PriorityQueue[] charIdx = new PriorityQueue[26];
        for (int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            int idx = c - 'a';
            if(charIdx[idx] == null){
                charIdx[idx] = new PriorityQueue();
            }
            charIdx[idx].add(i);
        }
        int cnt = 0;
        for (PriorityQueue<Integer> arr : charIdx){
            if(arr == null){
                continue;
            }else{
                while (arr.size() >= 3){
                    int first = arr.poll();
                    int second = arr.poll();
                    int third = arr.poll();
                    arr.add(second);
                }
                cnt += arr.size();
            }
        }
        return cnt;
    }
}