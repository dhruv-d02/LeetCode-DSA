class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prefix = 1;
        int[] products = new int[nums.length];
        int n = nums.length;
        for(int i=0; i<n; i++){
            products[i] = prefix;
            prefix = prefix*nums[i];   
        }
        int suffix = 1;
        for(int i=n-1;i>=0; i--){
            products[i] = suffix*products[i];
            suffix *= nums[i];
        }
        return products;
    }
}