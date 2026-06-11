import java.util.ArrayList;
import java.util.List;

class Solution {
    int mod = 1000000007;
    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;
        List<Integer>[] adjList = new List[n+1];
        for (int[] edge : edges) {
            if(adjList[edge[0]] == null)
                adjList[edge[0]] = new ArrayList<>();
            if(adjList[edge[1]] == null)
                adjList[edge[1]] = new ArrayList<>();

            adjList[edge[0]].add(edge[1]);
            adjList[edge[1]].add(edge[0]);
        }
        int height = getHeight(1, 0, adjList);
        return (int) pow(2, height-1);
    }

    private long pow(long base, int h) {
        long res = 1;

        while(h > 0){
            if(h%2 > 0){
                res = (res*base)%mod;
            }
            base = (base*base)%mod;
            h = h/2;
        }
        return res;
    }

    private int getHeight(int curr, int parent, List<Integer>[] adjList) {
        int height = 0;
        for(int node : adjList[curr]){
            if(node != parent)
                height = Math.max(height, getHeight(node, curr, adjList)+1);
        }
        return height;
    }
}