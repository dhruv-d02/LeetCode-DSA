import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int findMinDifference(List<String> timePoints) {
        int diff = Integer.MAX_VALUE;
        Collections.sort(timePoints, new MyComparator());
        //System.out.println(timePoints.get(0));
        for (int idx = 1; idx < timePoints.size(); idx++) {
            //System.out.println(timePoints.get(idx));
            String t1 = timePoints.get(idx-1);
            String t2 = timePoints.get(idx);
            String[] one = t1.split(":");
            String[] second = t2.split(":");

            int h1 = Integer.parseInt(one[0]);
            int m1 = Integer.parseInt(one[1]);
            int h2 = Integer.parseInt(second[0]);
            int m2 = Integer.parseInt(second[1]);
            if(h1 == 0){
                int th = 24;
                int d = Math.min(diff, ((th*60+m1) - (h2*60+m2)));
                if(d > 0){
                    diff = Math.min(diff, d);
                }
            }
            diff = Math.min(diff, ((h2*60+m2) - (h1*60+m1)));
        }
        if(timePoints.size() > 2) {
            String t1 = timePoints.get(0);
            String t2 = timePoints.get(timePoints.size() - 1);
            String[] one = t1.split(":");
            String[] second = t2.split(":");

            int h1 = Integer.parseInt(one[0]);
            int m1 = Integer.parseInt(one[1]);
            int h2 = Integer.parseInt(second[0]);
            int m2 = Integer.parseInt(second[1]);
            h1 += 24;
            int d = Math.min(diff, ((h1 * 60 + m1) - (h2 * 60 + m2)));
            if(d > 0){
                diff = Math.min(d, diff);
            }
        }
        return diff;
    }
}

class MyComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return o1.compareTo(o2);
    }
}