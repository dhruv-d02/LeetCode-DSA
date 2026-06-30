import java.util.HashMap;

class Solution {
    public int numberOfSubstrings(String s) {
        HashMap<Character , Integer> map = new HashMap<>();
        int start = 0, end = 1;
        map.put(s.charAt(start), map.getOrDefault(s.charAt(start), 0)+1);
        int ans = 0;
        while(end < s.length()){
            map.put(s.charAt(end), map.getOrDefault(s.charAt(end), 0)+1);
            while (map.size() == 3){
                ans += s.length() - end;
                map.put(s.charAt(start), map.get(s.charAt(start))-1);
                if(map.get(s.charAt(start)) == 0){
                    map.remove(s.charAt(start));
                }
                start++;
            }
            end++;
        }
        return ans;
    }
}