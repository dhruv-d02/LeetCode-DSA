import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int[] pre : prerequisites){
            adjList.get(pre[0]).add(pre[1]);
        }

        boolean[] vis = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if(!vis[i]){
                if(isCycle(i, recStack, vis,adjList))
                    return false;
            }
        }

        return true;
    }

    private boolean isCycle(int curr, boolean[] recStack, boolean[] vis, List<List<Integer>> adjList) {
        if(recStack[curr] == true)
            return true; //Cycle Exist
        if(vis[curr]) return false;
        vis[curr] = true;
        recStack[curr] = true;
        for(int neighbor : adjList.get(curr)){
            if(isCycle(neighbor, recStack, vis, adjList)) return true;
        }
        recStack[curr] = false;
        return false;
    }
}