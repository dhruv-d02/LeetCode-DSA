class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int[] relative = new int[nums.length + 1];
        for(int i=0; i<nums.length; i++)
        {
            if(i==0)
                relative[0] = nums[0];
            else
                relative[i] = nums[i] - nums[i-1];
        }
        relative[relative.length - 1] = 0;

        for (int[] q : queries)
        {
            relative[q[0]] -= 1;
            relative[q[1] + 1] += 1;
        }

        for(int i=0; i<relative.length-1; i++)
        {
            if(i==0)
            {
                if(relative[0] > 0)
                    return false;
            }
            else
            {
                relative[i] += relative[i-1];
                if(relative[i] > 0)
                    return false;
            }
        }
        return true;
    }
}