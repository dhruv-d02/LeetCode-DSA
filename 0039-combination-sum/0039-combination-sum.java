import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> ret;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ret = new ArrayList<>();
        helper(candidates, 0, 0, target, new ArrayList<Integer>());
        return ret;
    }

    private void helper(int[] candidates, int index, int currSum, int target, ArrayList<Integer> currCombination) {
        if(target == currSum){
            ret.add(new ArrayList<>(currCombination));
            return;
        }
        if(currSum > target || index >= candidates.length){
            return;
        }
        currCombination.add(candidates[index]);
        helper(candidates, index, currSum+candidates[index], target, currCombination);
        currCombination.remove(Integer.valueOf(candidates[index]));
        helper(candidates, index+1, currSum, target, currCombination);
    }
}