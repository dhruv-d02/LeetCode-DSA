import java.util.ArrayList;
import java.util.List;

class Solution {
    public String findDifferentBinaryString(String[] nums) {
        List<String> allStrings = new ArrayList<>();
        generateAllBinary(nums.length, allStrings, new StringBuilder());
        for (String s : nums){
            allStrings.remove(s);
        }
        return allStrings.get(0);
    }

    private void generateAllBinary(int length, List<String> allStrings, StringBuilder curr) {
        if(curr.length() == length) {
            allStrings.add(curr.toString());
            return;
        }
        for (int i = 0; i < 2; i++) {
            curr.append(i);
            generateAllBinary(length, allStrings, curr);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}