import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int[] ret = new int[2];
        int pos = 0;
        HashMap<Integer, Boolean> map = new HashMap<>();
        for(int n : nums){
            if(map.containsKey(n)){
                ret[pos] = n;
                pos++;
            }
            map.put(n, true);
        }
        Arrays.sort(ret);
        return  ret;
    }
}