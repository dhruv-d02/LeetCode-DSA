import java.lang.reflect.Array;
import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ret = new ArrayList<>();
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        
        for(String s : strs)
        {
            char[] st = s.toCharArray();
            Arrays.sort(st);
            ArrayList<String> sl = map.getOrDefault(new String(st), new ArrayList<>());
            sl.add(new String(s));
            map.put(new String(st), sl);
        }
        for(Map.Entry<String, ArrayList<String>> entry : map.entrySet())
        {
            ret.add(entry.getValue());
        }
        return ret;
    }
}