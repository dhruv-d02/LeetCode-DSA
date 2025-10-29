class Solution {
    public int countValidSelections(int[] nums) {
        int counter=0;
        for(int i=0; i<nums.length;i++)
        {
            if(nums[i]==0)
            {
                //add all elements to the left and right, if those values are equal, increment counter
                int dif = diff(i, nums);
                //works for both directions
                if(dif==0)
                {
                    counter+=2;
                }
                //Works for only 1 direction
                else if(dif==1)
                {
                    counter+=1;
                }
            }
            
        }
        return counter;
    }
    
    /**
    Sum up the left side and right side of an array except the index.
    and get the difference.
     */
    public int diff(int index, int[] nums)
    {
        int left=0;
        int right=0;
        for(int i=0; i<index; i++)
        {
            left+=nums[i];
        }
        for(int i=index+1; i<nums.length; ++i)
        {
            right+=nums[i];
        }
        return Math.abs(left-right);
    }
}