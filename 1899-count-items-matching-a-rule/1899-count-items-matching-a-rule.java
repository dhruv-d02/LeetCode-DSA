import java.util.List;

class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int cnt = 0;
        int key = 0;
        switch (ruleKey){
            case "type":
                key = 0;
                break;
            case "color":
                key = 1;
                break;
            case "name":
                key = 2;
                break;
        }
        for (List<String> item : items){
            if(item.get(key).equals(ruleValue)){
                cnt++;
            }
        }
        return  cnt;
    }
}