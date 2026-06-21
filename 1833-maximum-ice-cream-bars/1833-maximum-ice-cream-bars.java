import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class Solution {
    public int maxIceCream(int[] costs, int coins) {
        TreeMap<Integer, Integer> freqMap = new TreeMap<>();

        for(int cost : costs){
            freqMap.put(cost, freqMap.getOrDefault(cost, 0) + 1);
        }

        int count = 0;
        for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()){
            int cost = entry.getKey();
            int freq = entry.getValue();
            int maxBuy = Math.min(freq,coins/cost);
            count += maxBuy;
            coins -= maxBuy*cost;
        }
        return count;
    }
}