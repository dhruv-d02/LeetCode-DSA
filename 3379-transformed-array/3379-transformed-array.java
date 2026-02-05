class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int[] res = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0){
                res[i] = nums[i];
                continue;
            }
            if(nums[i] > 0){
                int rem = nums[i] % nums.length;
                if(rem + i < nums.length)
                    res[i] = nums[rem+i];
                else{
                    rem = rem - (nums.length - 1 - i + 1);
                    res[i] = nums[rem];
                    //0 1 2 3 4 5 6 7 8 9
                }
            }else{
                int rem = Math.abs(nums[i])%nums.length;
                if(i - rem >= 0)
                    res[i] = nums[i-rem];
                else
                    res[i] = nums[(nums.length - 1) - (rem - i - 1)];
            }
        }
        return res;
    }
}