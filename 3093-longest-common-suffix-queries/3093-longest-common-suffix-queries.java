class Solution {
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        TrieNode root = new TrieNode();
        for (int i = 0; i < wordsContainer.length; i++) {
            String word = wordsContainer[i];
            int len = word.length();
            TrieNode curr = root;
            
            if(curr.best_len > len || (curr.best_len == len && curr.best_idx > i)){
                curr.best_idx = i;
                curr.best_len = len;
            }

            for (int j = len-1; j >= 0; j--) {
                if(curr.nodes[word.charAt(j)-'a'] == null){
                    curr.nodes[word.charAt(j)-'a'] = new TrieNode();
                }
                curr = curr.nodes[word.charAt(j)-'a'];
                
                if(curr.best_len > len || (curr.best_len == len && curr.best_idx > i)){
                    curr.best_idx = i;
                    curr.best_len = len;
                }
            }
        }
        
        int[] res = new int[wordsQuery.length];
        
        for (int i = 0; i < wordsQuery.length; i++) {
            TrieNode curr = root;
            String word = wordsQuery[i];
            int len = word.length();
            for (int j = len-1; j >= 0 ; j--) {
                if(curr.nodes[word.charAt(j)-'a'] == null)
                    break;
                curr = curr.nodes[word.charAt(j)-'a'];
            }
            res[i] = curr.best_idx;
        }
        
        return res;
    }
}
class TrieNode{
    TrieNode[] nodes = new TrieNode[26];
    int best_len = Integer.MAX_VALUE;
    int best_idx = Integer.MAX_VALUE;
}