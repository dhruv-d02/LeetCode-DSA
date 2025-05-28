import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n = edges1.length+1;
        int m = edges2.length+1;
        int[] maxTargets = new int[n];
        
        if(k == 0){
            for (int i=0; i<n; i++){
                maxTargets[i] += 1;
            }
            return maxTargets;
        }
        
        List<ArrayList<Integer>> adjList1 = new ArrayList<>();
        List<ArrayList<Integer>> adjList2 = new ArrayList<>();

        for (int i=0; i<Math.max(m,n); i++){
            if(i<n){
                adjList1.add(new ArrayList<>());
            }
            if(i < m){
                adjList2.add(new ArrayList<>());
            }
        }

        int[] maxNodes1 = new int[n];
        int[] maxNodes2 = new int[m];

        for(int[] edge : edges1){
            adjList1.get(edge[0]).add(edge[1]);
            adjList1.get(edge[1]).add(edge[0]);
        }


        for(int[] edge : edges2){
            adjList2.get(edge[0]).add(edge[1]);
            adjList2.get(edge[1]).add(edge[0]);
        }

        for(int i=0; i<n; i++){
            maxNodes1[i] = maxNodesAtDistance(i, adjList1, k, i);
        }

        int maxChild = 0;

        for (int i = 0; i < m; i++) {
            maxNodes2[i] = maxNodesAtDistance(i, adjList2, k - 1, i);
            maxChild = Math.max(maxChild, maxNodes2[i]);
        }

        for(int i=0; i<n; i++){
            maxTargets[i] = maxNodes1[i] + maxChild + 2;
        }

        return maxTargets;
    }

    private int maxNodesAtDistance(int currNode, List<ArrayList<Integer>> adjList, int k, int from) {
        if(k == 0){
            if(currNode == from)
                return 0;
            return 1;
        }

        int ans = 0;
        for(int to : adjList.get(currNode)){
            if(to == from){
                continue;
            }

            ans += maxNodesAtDistance(to, adjList, k-1, currNode);
        }
        if(currNode == from){
            return ans;
        }
        return ans + 1;
    }
}