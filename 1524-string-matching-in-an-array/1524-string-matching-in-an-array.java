import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> ans = new ArrayList<>();
        Trie trie = new Trie();
        for (int i=0; i<words.length; i++){
            for (int j=0; j<words[i].length(); j++) {
                String sub = words[i].substring(j);
                trie.insert(sub, 0);
            }
        }
        for (String word : words){
            if(trie.isASubstring(word, 0)){
                ans.add(word);
            }
        }
        return ans;
    }
}

class Trie{
    Trie[] characters;
    boolean end;
    int count;
    Trie() {
        characters = new Trie[26];
        end = false;
        count = 0;
    }

    public void insert(String s, int idx){
        if(idx >= s.length()){
            return;
        }
        char c = s.charAt(idx);
        if(this.characters[c-'a'] != null){
            this.characters[c-'a'].insert(s, idx+1);
        }else{
            this.characters[c-'a'] = new Trie();
            this.characters[c-'a'].insert(s, idx+1);
        }
        this.characters[c-'a'].count++;
        if(idx == s.length()-1){
            this.end = true;
        }
    }
    public boolean isEnd() {
        return this.end;
    }

    public boolean isASubstring(String s, int idx){
        if(idx == s.length()){
            return this.count > 1;
        }
        char c = s.charAt(idx);
        if(this.characters[c-'a'] != null){
            return this.characters[c-'a'].isASubstring(s, idx+1);
        }else{
            return false;
        }
    }
}