import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class Solution {
    public String majorityFrequencyGroup(String s) {
        HashMap<Integer, String> group = new HashMap<>();
        int[] freq = new int[26];
        for(char c : s.toCharArray()){
            freq[c-'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if(freq[i] != 0){
                group.put(freq[i], group.getOrDefault(freq[i], "") + (char)('a'+ i));
            }
        }

        String ans = "";
        int f = 0;
        for (Map.Entry<Integer, String> entry : group.entrySet()){
            if(entry.getValue().length() > ans.length()){
                ans = entry.getValue();
                f = entry.getKey();
            }else if(entry.getValue().length() == ans.length()){
                if(entry.getKey() > f){
                    ans = entry.getValue();
                    f = entry.getKey();
                }
            }
        }
        return ans;
    }
}