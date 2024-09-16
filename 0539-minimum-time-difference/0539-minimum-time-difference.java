import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int findMinDifference(List<String> timePoints) {
        if(timePoints.size() > 1440){
            return 0;
        }
        boolean[] seen = new boolean[1440];
        for(String time : timePoints){
            int min = convert(time);
            //System.out.println(min);
            if(seen[min]){
                return 0;
            }
            seen[min] = true;
        }
        int prev = Integer.MAX_VALUE;
        int first = Integer.MAX_VALUE;
        int diff = Integer.MAX_VALUE;
        for(int i=0; i<1440; i++){
            if(seen[i]){
                if(first == Integer.MAX_VALUE){
                    first = i;
                }else{
                    diff = Math.min(diff, i-prev);
                }
                prev = i;
            }
        }
        diff = Math.min(diff, 1440-prev + first);
        return diff;
    }

    private int convert(String time) {
        String[] t = time.split(":");
        return Integer.parseInt(t[0])*60 + Integer.parseInt(t[1]);
    }
}