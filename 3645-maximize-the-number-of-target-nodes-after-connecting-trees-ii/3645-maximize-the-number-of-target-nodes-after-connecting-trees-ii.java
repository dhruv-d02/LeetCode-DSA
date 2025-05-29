import java.util.*;

public class Solution {
    int evenA = 0, oddA = 0, evenB = 0, oddB = 0;

    private List<List<Integer>> buildList(int[][] edges) {
        int n = edges.length + 1;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        return adj;
    }

    private void bfsColor(List<List<Integer>> adj, int[] color, boolean isA) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        color[0] = 0;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            if (color[u] == 0) {
                if (isA) evenA++;
                else evenB++;
            } else {
                if (isA) oddA++;
                else oddB++;
            }

            for (int v : adj.get(u)) {
                if (color[v] == -1) {
                    color[v] = color[u] ^ 1;
                    queue.add(v);
                }
            }
        }
    }

    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        List<List<Integer>> adjA = buildList(edges1);
        List<List<Integer>> adjB = buildList(edges2);
        int n = adjA.size(), m = adjB.size();
        int[] colorA = new int[n];
        int[] colorB = new int[m];
        Arrays.fill(colorA, -1);
        Arrays.fill(colorB, -1);

        evenA = oddA = evenB = oddB = 0;
        bfsColor(adjA, colorA, true);
        bfsColor(adjB, colorB, false);

        int maxiB = Math.max(evenB, oddB);
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = ((colorA[i] == 0 ? evenA : oddA) + maxiB);
        }
        return res;
    }
}