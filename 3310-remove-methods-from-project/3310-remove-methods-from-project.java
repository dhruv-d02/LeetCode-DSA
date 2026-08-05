import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {

    boolean[] suspicious;
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        suspicious = new boolean[n];

        List<List<Integer>> adjList = new ArrayList<>();

        for(int i=0; i<n; i++)
            adjList.add(new ArrayList<>());

        for (int[] in : invocations){
            adjList.get(in[0]).add(in[1]);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(k);

        while (!queue.isEmpty()){
            int sus = queue.poll();
            if(suspicious[sus])
                continue;
            suspicious[sus] = true;
            List<Integer> newSus = adjList.get(sus);
            for (int i = 0; i < newSus.size(); i++) {
                if(suspicious[newSus.get(i)])
                    continue;
                queue.add(newSus.get(i));
            }
        }

        boolean removalPossible = true;
        for(int[] inv : invocations){
            int u = inv[0];
            int v = inv[1];
            
            if(!suspicious[u] && suspicious[v]){
                removalPossible = false;
            }
        }
        List<Integer> safeFun = new ArrayList<>();
        if(removalPossible) {
            for (int i = 0; i < n; i++) {
                if (!suspicious[i])
                    safeFun.add(i);
            }
        }else{
            for (int i = 0; i < n; i++) {
                safeFun.add(i);
            }
        }

        return safeFun;
    }

    private void removeSuspicion(int k, int n, List<List<Integer>> adjList) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(k);
        boolean[] vis = new boolean[n];
        while (!queue.isEmpty()){
            int sus = queue.poll();
            if(vis[sus]) continue;
            vis[sus] = true;
            suspicious[sus] = false;
            queue.addAll(adjList.get(sus));
        }

    }


}