class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Node trie = new Node();
        for (int i = 0; i < arr1.length; i++) {
            trie.add(arr1[i] + "", 0);
        }
        int ans = 0;
        for(int i=0; i<arr2.length; i++){
            ans = Math.max(trie.longest(arr2[i] + "", 0), ans);
        }
        return ans;
    }
}

class Node{
    Node[] nodes;
    boolean end;

    public Node() {
        this.nodes = new Node[10];
    }

    public void add(String s, int i){
        if(i == s.length()){
            this.end = true;
            return;
        }
        int idx = s.charAt(i)-'0';
        if(this.nodes[idx] == null){
            this.nodes[idx] = new Node();
        }
        nodes[idx].add(s, i+1);
    }

    public int longest(String s, int i){
        if(i == s.length()){
            return s.length();
        }
        int idx = s.charAt(i) -'0';
        if(this.nodes[idx] == null){
            return i;
        }
        return nodes[idx].longest(s, i+1);
    }

}