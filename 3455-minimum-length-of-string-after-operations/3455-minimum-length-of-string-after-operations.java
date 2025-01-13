import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public int minimumLength(String s) {
        int[] charOccurence = new int[26];
        for (char c : s.toCharArray()){
            charOccurence[c-'a']++;
        }
        int cnt = 0;
        for(int occ : charOccurence){
            if(occ ==0){
                continue;
            }
            if(occ%2 == 0){
                cnt += 2;
            }else{
                cnt+=1;
            }
        }
        return cnt;
    }
}