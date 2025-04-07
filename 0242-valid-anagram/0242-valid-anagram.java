import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        HashMap<Character, Integer> charMap = new HashMap<>();
        for(int i=0; i<s.length(); i++)
        {
            charMap.put(s.charAt(i), charMap.getOrDefault(s.charAt(i), 0)+1);
            charMap.put(t.charAt(i), charMap.getOrDefault(t.charAt(i), 0)-1);
        }
        for(Map.Entry<Character, Integer> entry : charMap.entrySet())
        {
            if(entry.getValue() != 0)
                return false;
        }
        return true;
    }
}