import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int countValidSelections(int[] nums) {
        int validPos = 0;
        for(int i=0; i<nums.length; i++){
            int[] temp = nums;
            if(nums[i] == 0){
                if(valid(Arrays.copyOf(nums, nums.length), i, true)){
                    validPos++;
                }
                if(valid(Arrays.copyOf(nums, nums.length), i, false)){
                    validPos++;
                }
            }
        }
        return validPos;
    }

    private boolean valid(int[] nums, int curr, boolean toRight) {
        for (int i=curr; i<nums.length && i>=0;){
            int val = nums[i];
            if(val == 0){
                if(toRight){
                    i++;
                }else{
                    i--;
                }
                continue;
            }
            nums[i]--;
            toRight = !toRight;
            if(toRight){
                i++;
            }else{
                i--;
            }
        }
        for(int n : nums){
            if(n != 0){
                return false;
            }
        }
        return true;
    }
}