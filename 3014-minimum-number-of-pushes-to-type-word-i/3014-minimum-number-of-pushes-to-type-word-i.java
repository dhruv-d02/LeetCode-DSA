import java.util.HashMap;

class Solution {
    public int minimumPushes(String word) {
        HashMap<Character, Integer> map = new HashMap<>();

        int count = 0;
        int curr = 1;
        for(int i=0; i<word.length(); i++){
            if(i != 0 && i%8 == 0)
                curr++;
            if(map.get(word.charAt(i)) == null){
                map.put(word.charAt(i), curr);
            }

            count += map.get(word.charAt(i));
        }

        return count;
    }
}