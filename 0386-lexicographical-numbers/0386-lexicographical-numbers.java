import java.util.*;

class Solution {
    List<Integer> ret;
    public List<Integer> lexicalOrder(int n) {
        ret = new ArrayList<>();
        recursiveTrie(0, n);
        return ret;
    }

    private void recursiveTrie(int node, int n) {
        for (int i = node;i<=Math.min(node+9, n);i++){
            if(i==0) continue;
            ret.add(i);
            if(i*10 <= n){
                recursiveTrie(i*10, n);
            }
        }
    }
}