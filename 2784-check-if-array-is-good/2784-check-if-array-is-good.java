class Solution {
    public boolean isGood(int[] nums) {
        int[] base = new int[201];
        int max = Integer.MIN_VALUE;

        for(int n : nums){
            base[n]++;
            max = Math.max(n, max);
        }
        // System.out.println(max);
        if(max+1 != nums.length || base[max] != 2){
        // System.out.println("max1 ");
            return false;
        }

        for(int i=1; i<max; i++){
            if(base[i] != 1){
                // System.out.println("max2");
                return false;
            }
        }
        return true;
    }
}