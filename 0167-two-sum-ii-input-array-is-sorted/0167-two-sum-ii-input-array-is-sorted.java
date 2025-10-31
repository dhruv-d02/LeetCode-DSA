import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int r = numbers.length-1;
        int l = 0;

        while (r > l){
            int sum = numbers[r] + numbers[l];
            if(sum == target){
                return new int[]{l+1, r+1};
            }
            if(sum < target){
                l++;
            }
            if(sum > target){
                r--;
            }
        }
        return null;
    }
}