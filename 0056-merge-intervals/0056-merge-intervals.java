import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 1)
            return intervals;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return o1[1]-o2[1];
                }
                return o1[0] - o2[0];
            }
        });

        List<int[]> retList = new ArrayList<>();

        int i=0, j = 1;

        while (i<intervals.length && j <intervals.length){
            int start = intervals[i][0];
            int end = intervals[i][1];
            if(intervals[i][1] >= intervals[j][0]){
                int currEnd = Math.max(intervals[j][1], intervals[i][1]);
                while (j<intervals.length && currEnd >= intervals[j][0]){
                    currEnd = Math.max(currEnd,intervals[j][1]);
                    j++;
                }
                end = currEnd;
                i = j;
                j = i+1;
            }else{
                i++;
                j++;
            }
            retList.add(new int[]{start, end});
        }
        if(i<=intervals.length-1){
            while (i< intervals.length){
                int[] last = retList.getLast();
                retList.remove(retList.size()-1);
                if(last[1] >= intervals[i][0]){
                    int currEnd = Math.max(last[1], intervals[i][1]);
                    i++;
                    while (currEnd >= intervals[i][0]){
                        currEnd = Math.max(currEnd, intervals[i][1]);
                        i++;
                    }
                    retList.add(new int[]{last[0], currEnd});
                }else{
                    retList.add(last);
                    retList.add(intervals[i]);
                    i++;
                }
            }
        }
        int[][] retArr = new int[retList.size()][2];

        for (int k = 0; k < retList.size(); k++) {
            retArr[k] = retList.get(k);
        }

        return retArr;
    }
}