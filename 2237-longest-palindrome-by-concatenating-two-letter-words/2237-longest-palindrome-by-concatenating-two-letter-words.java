import java.util.HashMap;
import java.util.Map;

class Solution {
    public int longestPalindrome(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();

        for(String s : words){
            map.put(s, map.getOrDefault(s, 0)+1);
        }

        String pallindrome = "";

        boolean singlePallindromeAdded = false;
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            String word = entry.getKey();
            String revWord = "" + word.charAt(1) + word.charAt(0);
            if(map.get(word) == null || map.get(revWord) == null){
                continue;
            }
            while (Math.min(map.get(word), map.get(revWord)) > 0){
                if(word.charAt(0) == word.charAt(1) && map.get(word) == 1){
                    if(singlePallindromeAdded){
                        map.put(word, Math.min(map.get(word)-1, 0));
                        continue;
                    }
                    pallindrome = pallindrome + word;
                    singlePallindromeAdded = true;
                    map.put(word, map.get(word) - 1);
                }
                else {
                    pallindrome = word + pallindrome + revWord;
                    map.put(word, Math.max(map.get(word) - 1, 0));
                    map.put(revWord, Math.max(map.get(revWord) - 1, 0));
                }
            }
        }
        return pallindrome.length();
    }
}