import java.util.*;

class Solution {
    public int maxRemoval(int[] nums, int[][] queries) {

        PriorityQueue<int[]> queriesImpacting = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        PriorityQueue<Integer> pastQueries = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        Arrays.sort(queries, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0])
                    return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });
        int queryUsed = 0;
        int queryPos = 0;
        for(int i=0; i<nums.length; i++){
            while (!pastQueries.isEmpty() && pastQueries.peek() < i){
                pastQueries.poll();
            }
            if(!pastQueries.isEmpty() && pastQueries.peek()>=i && nums[i] != 0){
                nums[i] -= Math.min(nums[i], pastQueries.size());
            }

            boolean positionImpacted = false;
            for(int j=queryPos; j<queries.length; j++){
                if(queries[j][0]<=i){
                    queriesImpacting.add(queries[j]);
                    positionImpacted = true;
                }else {
                    break;
                }
                queryPos++;
            }
            if(nums[i] == 0){
                continue;
            }

            while (!queriesImpacting.isEmpty() && nums[i] != 0){
                int[] q = queriesImpacting.poll();
                if(!(q[1] >= i)){
                    continue;
                }
                pastQueries.add(q[1]);
                nums[i]--;
                queryUsed++;
            }
            if(nums[i] != 0)
                return -1;
        }
        return queries.length - queryUsed >= 0 ? queries.length - queryUsed : -1;


    }
}