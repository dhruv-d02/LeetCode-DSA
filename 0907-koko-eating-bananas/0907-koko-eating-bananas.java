import java.util.Arrays;

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int minTime = Integer.MAX_VALUE;
        int start = 1;
        int end = Arrays.stream(piles).max().getAsInt();
        while (start <= end){
            int mid = start + (end - start)/2;
            long hoursTaken = 0;
            for(int pile : piles){
                hoursTaken += Math.ceilDiv(pile, mid);
            }
            if(hoursTaken <= h){
                minTime = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return minTime;
    }

    
}