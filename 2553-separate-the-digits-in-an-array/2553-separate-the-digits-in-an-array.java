import java.util.ArrayList;

class Solution {
    public int[] separateDigits(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();

        for(int num : nums){
            String n = num + "";
            for (char c : n.toCharArray()){
                list.add(c-'0');
            }
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}