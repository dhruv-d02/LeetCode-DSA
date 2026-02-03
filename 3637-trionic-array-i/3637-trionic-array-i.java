class Solution {
    public boolean isTrionic(int[] nums) {
        int cnt = 1;
        int[] pos = new int[]{-1, -1};
        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i+1] > nums[i]){
                if(cnt == 1 || cnt == 3)
                    continue;
                else if(cnt == 2) {
                    pos[1] = i;
                    cnt = 3;
                }
                else
                    return false;
            }else if(nums[i+1] < nums[i]){
                if(cnt == 1){
                    pos[0] = i;
                    cnt = 2;
                }else if(cnt == 2)
                    continue;
                else
                    return false;
            }else {
                return false;
            }
        }
        if(pos[0] > 0 && pos[1] < nums.length - 1 && pos[1] > pos[0])
            return true;
        return false;
    }
}