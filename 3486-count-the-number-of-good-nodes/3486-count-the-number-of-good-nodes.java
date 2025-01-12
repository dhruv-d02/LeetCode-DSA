import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    int cnt;
    public int countGoodNodes(int[][] edges) {
        cnt = 0;
        HashMap<Integer, Tree> treeMap = new HashMap<>();
        for (int[] edge : edges){
            treeMap.putIfAbsent(edge[0], new Tree(edge[0]));
            treeMap.putIfAbsent(edge[1], new Tree(edge[1]));
            treeMap.get(edge[0]).branches.add(treeMap.get(edge[1]));
            treeMap.get(edge[1]).branches.add(treeMap.get(edge[0]));
        }
        traverse(treeMap, treeMap.get(0), null);
        return cnt;
    }

    private int traverse(HashMap<Integer, Tree> treeMap, Tree tree, Tree parent) {
        int childCnt = 0;
        int prevCnt = -1;
        boolean trueTree = true;
        for (Tree t : tree.branches){
            if(parent != null && t.val == parent.val){
                continue;
            }
            int childs = traverse(treeMap,t, tree);
            childCnt += childs;
            if(prevCnt == -1){
                prevCnt = childs;
            }else{
                if(prevCnt != childs){
                    trueTree = false;
                }
            }
        }
        if(trueTree){
            this.cnt++;
        }
        return childCnt+1;
    }

    class Tree{
        int val;
        List<Tree> branches;

        public Tree(int val) {
            this.branches = new ArrayList<>();
            this.val = val;
        }
    }
}