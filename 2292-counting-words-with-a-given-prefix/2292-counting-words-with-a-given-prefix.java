class Solution {
    public int prefixCount(String[] words, String pref) {
        Trie trie = new Trie();
        for (String word : words){
            trie.insert(word, 0);
        }
        return trie.getCount(pref, 0);
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

    public int count(String s, int idx){
        if(idx == s.length()){
            return this.count > 1 ? this.count-1 : -1;
        }
        char c = s.charAt(idx);
        if(this.characters[c-'a'] != null){
            return this.characters[c-'a'].count(s, idx+1);
        }else{
            return -1;
        }
    }

    public int getCount(String s, int idx) {
        if(idx == s.length()){
            return this.count;
        }
        char c = s.charAt(idx);
        if(this.characters[c-'a'] != null){
            return this.characters[c-'a'].getCount(s, idx+1);
        }
        return 0;
    }
}