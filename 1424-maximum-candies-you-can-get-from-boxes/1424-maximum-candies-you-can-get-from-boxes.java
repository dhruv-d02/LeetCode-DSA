import java.util.*;

class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int n = status.length;
        boolean[] visited = new boolean[n];
        boolean[] boxOwned = new boolean[n];
        boolean[] boxOpened = new boolean[n];
        Set<Integer> keySet = new HashSet<>();

        Queue<Integer> queue = new LinkedList<>();

        for (int box : initialBoxes) {
            boxOwned[box] = true;
            queue.offer(box);
        }

        int totalCandies = 0;

        boolean progress = true;
        while (progress) {
            progress = false;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int box = queue.poll();

                // Can open only if already open or we have the key
                if (status[box] == 1 || keySet.contains(box)) {
                    if (visited[box]) continue;

                    visited[box] = true;
                    progress = true;

                    totalCandies += candies[box];

                    for (int k : keys[box]) {
                        keySet.add(k);
                        if (boxOwned[k]) queue.offer(k); // retry if we already own the box
                    }

                    for (int b : containedBoxes[box]) {
                        boxOwned[b] = true;
                        queue.offer(b); // add to queue to process
                    }
                } else {
                    // Put it back in the queue to retry later if we get its key
                    queue.offer(box);
                }
            }
        }

        return totalCandies;
    }
}
