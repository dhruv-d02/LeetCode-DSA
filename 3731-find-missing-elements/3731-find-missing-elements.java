class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int[] freq = new int[101];
        int small = 101;
        List<Integer> ans = new ArrayList<>();
        int largest = -1;
        for(int n : nums){
            small = Math.min(small, n);
            largest = Math.max(largest, n);
            freq[n]++;
        }

        for(int i=small; i<=largest; i++){
            if(freq[i] == 0)
                ans.add(i);
        }

        return ans;
    }
}