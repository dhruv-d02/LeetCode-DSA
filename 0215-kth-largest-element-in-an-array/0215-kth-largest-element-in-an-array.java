import java.util.Collections;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>(Collections.reverseOrder());
        for(int num : nums){
            treeMap.put(num, treeMap.getOrDefault(num, 0) + 1);
        }

        while (k > 0){
            Map.Entry<Integer, Integer> entry = treeMap.firstEntry();
            if(k > entry.getValue()){
                k -= entry.getValue();
                treeMap.remove(entry.getKey());
            }else{
                break;
            }
        }
        return treeMap.firstEntry().getKey();
    }
}