class Solution {
    private class Node{
        HashMap<String, Node> child;
        int count;
        Node(){
            this.child = new HashMap<>();
            this.count = 0;
        }
        boolean contains(char c1, char c2){
            String key = c1 + "x" + c2;
            return child.containsKey(key);
        }
        void insert(char c1, char c2, Node node){
            String key = c1 + "x" + c2;
            child.put(key, node);
        }
        Node next(char c1, char c2){
            String key = c1 + "x" + c2;
            return child.get(key);
        }
        
    }
    private class Trie{
        private Node root;
        Trie(){
            root = new Node();
        }
        void add(String w){
            Node curr = root;
            int r = w.length() - 1;
            for(int l = 0; l < w.length() && r >= 0; l++){
                char c1 = w.charAt(l);
                char c2 = w.charAt(r);
                if(!curr.contains(c1, c2)){
                    curr.insert(c1, c2, new Node());
                }
                curr = curr.next(c1, c2);
                r--;
                curr.count += 1;
            }
        }
        int count(String w){
            Node curr = root;
            int r = w.length() - 1;
            for(int l = 0; l < w.length() && r >= 0; l++){
                char c1 = w.charAt(l);
                char c2 = w.charAt(r);
                if(!curr.contains(c1, c2)){
                    return 0;
                }
                curr = curr.next(c1, c2);
                r--;
            }
            return curr.count;
        }
    }
    public int countPrefixSuffixPairs(String[] words) {
        int res = 0;
        Trie node = new Trie();

        for(int i = words.length - 1; i >= 0; i--){
            res += node.count(words[i]);
            node.add(words[i]);
        }
        return res;
    }
}