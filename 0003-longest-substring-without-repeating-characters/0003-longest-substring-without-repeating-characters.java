import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int startPos = 0;
        int currPos = 0;
        int ans = 0;
        HashMap<Character, Integer> cntMap = new HashMap<>();
        while (currPos < s.length()){
            if(cntMap.getOrDefault(s.charAt(currPos), 0) > 0){
                cntMap.remove(s.charAt(startPos));
                ans = Math.max(ans, currPos - startPos);
                startPos++;
            }else{
                cntMap.put(s.charAt(currPos), cntMap.getOrDefault(s.charAt(currPos), 0)+1);
                currPos++;
            }
        }
        return Math.max(ans, currPos - startPos);
    }
}