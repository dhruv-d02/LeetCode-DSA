import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        List<ArrayList<Integer>> adjList = new ArrayList<>();
        int n = edges.length;
        for(int i=0;i< n; i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0; i<edges.length; i++){
            if(edges[i] == -1){
                continue;
            }
            adjList.get(i).add(edges[i]);
        }

        Queue<int[]> queue = new LinkedList<>();
        int[] fromNode1 = new int[n];
        fromNode1[node1] = 0;
        queue.offer(new int[]{node1, 0});
        boolean[] visited = new boolean[n];
        while (!queue.isEmpty()){
            int[] curr = queue.poll();
            if(visited[curr[0]]){
                continue;
            }

            visited[curr[0]] = true;
            fromNode1[curr[0]] = curr[1];
            for (int to : adjList.get(curr[0])){
                queue.offer(new int[]{to, curr[1] + 1});
            }
        }

        int[] fromNode2 = new int[n];
        queue.offer(new int[]{node2, 0});
        boolean[] visited2 = new boolean[n];
        while (!queue.isEmpty()){
            int[] curr = queue.poll();
            if(visited2[curr[0]]){
                continue;
            }

            visited2[curr[0]] = true;
            fromNode2[curr[0]] = curr[1];
            for (int to : adjList.get(curr[0])){
                queue.offer(new int[]{to, curr[1] + 1});
            }
        }
        int ans = Integer.MAX_VALUE;
        int idx = -1;
        for(int i=0; i<n; i++){
            if(!visited[i] || !visited2[i]){
                continue;
            }
            if(ans > Math.max(fromNode1[i], fromNode2[i])){
                idx = i;
                ans = Math.max(fromNode1[i], fromNode2[i]);
            }
        }

        return idx;
    }
}