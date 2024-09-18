import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String largestNumber(int[] nums) {
        List<Integer> numList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Collections.sort(numList, new MyComparator());
        String ret = "";
        for (int i = 0; i < numList.size(); i++) {
            if(ret.equals("0")){
                ret = "";
            }
            ret += numList.get(i);
        }
        return ret;
    }
}
class MyComparator implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
        String a = o1 + ""+o2;
        String b = o2 + ""+o1;
        for (int i = 0; i < a.length(); i++) {
            if(Integer.parseInt(a.charAt(i)+"") > Integer.parseInt(b.charAt(i)+"")){
                return -1;
            }else if(Integer.parseInt(a.charAt(i)+"") < Integer.parseInt(b.charAt(i)+"")){
                return 1;
            }
        }
        return 0;
    }
}