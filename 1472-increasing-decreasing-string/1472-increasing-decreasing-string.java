import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

class Solution {
    public String sortString(String s) {
        StringBuilder res =  new StringBuilder();
        TreeMap<Character, Integer> charMap = new TreeMap<>();
        for(int i=0; i<s.length(); i++){
            if(charMap.get(s.charAt(i)) == null){
                charMap.put(s.charAt(i), 0);
            }
            charMap.put(s.charAt(i), charMap.get(s.charAt(i))+1);
        }

        while (!charMap.isEmpty()){
            List<Character> allCharSet = new ArrayList<>(charMap.keySet());
            for (int i=0; i<allCharSet.size()&& !charMap.isEmpty(); i++){
                //Step 1 -> 3
                char c = allCharSet.get(i);
                if(charMap.get(c) == null){
                    continue;
                }
                if(charMap.get(c) == 0){
                    charMap.remove(c);
                }else {
                    res.append(c);
                    charMap.put(c, charMap.get(c) - 1);
                }
            }
            for (int i=allCharSet.size()-1; i>=0 && !charMap.isEmpty(); i--){
                //Step 4 -> 6
                char c = allCharSet.get(i);
                if(charMap.get(c) == null){
                    continue;
                }
                if(charMap.get(c) == 0){
                    charMap.remove(c);
                }else {
                    res.append(c);
                    charMap.put(c, charMap.get(c) - 1);
                }
            }
        }

        return res.toString();

    }
}