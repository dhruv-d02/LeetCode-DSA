import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {

        boolean[] canVisit;
        Set<Integer> keysFound;
        int n = candies.length;
        canVisit = new boolean[n];
        keysFound = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int box : initialBoxes)
            queue.add(box);

        int total = 0;
        while (!queue.isEmpty()){
            int curr = queue.poll();
            if(curr == -1)
                continue;
            if(canVisit[curr]){
                continue;
            }

            canVisit[curr] = true;
            if(status[curr] == 0 && !keysFound.contains(curr)){
                queue.add(curr);
                continue;
            }
            if(status[curr] == 1 || keysFound.contains(curr)){
                total += candies[curr];
            }

            for(int key : keys[curr]){
                if(key != -1 && canVisit[key]) {
                    if(!keysFound.contains(key))
                        canVisit[key] = false;
                    queue.add(key);
                }
                keysFound.add(key);
            }

            for(int box : containedBoxes[curr]){
                queue.add(box);
            }
        }

        return total;
    }
}