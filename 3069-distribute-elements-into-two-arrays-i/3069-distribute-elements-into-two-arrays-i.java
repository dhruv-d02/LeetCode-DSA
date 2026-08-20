import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] resultArray(int[] nums) {
        Queue<Integer> arr1 = new LinkedList<>();
        Queue<Integer> arr2 = new LinkedList<>();

        arr1.add(nums[0]);
        arr2.add(nums[1]);
        int lp1 = arr1.peek();
        int lp2 = arr2.peek();

        for (int k = 2; k < nums.length; k++) {
            if(lp1 > lp2){
                arr1.add(nums[k]);
                lp1 = nums[k];
            }else{
                arr2.add(nums[k]);
                lp2 = nums[k];
            }
        }
        
        int[] res = new int[nums.length];
        
        int k = 0;
        while(!arr1.isEmpty()){
            res[k] = arr1.poll();
            k++;
        }

        while(!arr2.isEmpty()){
            res[k] = arr2.poll();
            k++;
        }
        
        return res;
    }
}