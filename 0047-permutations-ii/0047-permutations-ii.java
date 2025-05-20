import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backtrack(nums, used, new ArrayList<Integer>(), ret);
        return ret;

    }

    private void backtrack(int[] nums, boolean[] used, ArrayList<Integer> curr, List<List<Integer>> ret) {
        if(curr.size() == nums.length)
        {
            ret.add(new ArrayList<>(curr));
            return;
        }
        for(int i=0; i<nums.length; i++)
        {
            if(used[i]) continue;

            if(i>0 && nums[i] == nums[i-1] && !used[i-1])
                continue;

            used[i] = true;
            curr.add(nums[i]);
            backtrack(nums, used, curr, ret);
            curr.remove(curr.size() - 1);
            used[i] = false;
        }

    }
}