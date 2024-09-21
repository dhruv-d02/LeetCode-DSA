import java.util.*;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ret = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            ret.add(i);
        }
        Collections.sort(ret, new MyComparator());
        return ret;
    }
}

class MyComparator implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
        String a = o1 + "";
        String b = o2+ "";
        int lim = Math.min(a.length(), b.length());
        int ag = 0;
        for (int i = 0; i < lim; i++) {
            if(Integer.parseInt(a.charAt(i) + "") > Integer.parseInt(b.charAt(i) + "")){
                return 1;
            }else if(Integer.parseInt(a.charAt(i) + "") < Integer.parseInt(b.charAt(i) + "")){
                return -1;
            }
        }
        if(a.length() > b.length()){
            return 1;
        }else {
            return -1;
        }
    }
}