import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        ArrayList<String> retList = new ArrayList<>();
        String[] one = s1.split(" ");
        String[] second= s2.split(" ");
        HashMap<String, Integer> map = new HashMap<>();
        for(String s : one){
            if(map.get(s) == null){
                map.put(s, 0);
            }
            map.put(s, map.get(s)+1);
        }
        for (String s: second){
            if(map.get(s) == null){
                map.put(s, 0);
            }
            map.put(s, map.get(s)+1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()){
            if(entry.getValue() == 1){
                retList.add(entry.getKey());
            }
        }
        return retList.toArray(new String[retList.size()]);
    }
}