import java.util.HashMap;
import java.util.Map;

class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Node node = new Node();
        for(int n : arr1){
            node.add(n);
        }
        int ans = Integer.MIN_VALUE;
        for (int n : arr2){
            int longestPrefix = node.longestPrefix(n);
            ans = Math.max(ans, longestPrefix);
        }
        return ans;
    }
}

class Node{
    private Node[] arr;

    public Node() {
        this.arr = new Node[10];
    }

    public void add(int n){
        add(n + "", this);
    }

    private void add(String s, Node curr){
        for (int i=0; i<s.length(); i++){
            if(curr.arr[s.charAt(i) - '0'] == null){
                curr.arr[s.charAt(i) - '0'] = new Node();
            }
            curr = curr.arr[s.charAt(i) - '0'];
        }

    }

    public int longestPrefix(int n) {
        return longestPrefix(n+"", this, 0);
    }

    private int longestPrefix(String s, Node curr, int pos){
        if(pos == s.length())
            return 0;
        if(curr.arr[s.charAt(pos)-'0'] == null)
            return 0;
        return longestPrefix(s, curr.arr[s.charAt(pos) - '0'], pos+1) + 1;
    }
}