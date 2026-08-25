class Solution {
    public int missingMultiple(int[] nums, int k) {
        int[] check = new int[101];

        if(k==1){
            if(nums.length == 1){
                if(nums[0] == 1)
                    return 2;
                return 1;
            }
        }

        for(int n : nums){
            if(n%k == 0){
                int idx = n/k;
                System.out.println(idx);
                check[idx]++;
            }
        }

        for(int i=1; i<check.length; i++){
            if(check[i] == 0)
                return k*i;
        }
        return k*nums.length == 100 ? 101 : k*nums.length;
    }
}