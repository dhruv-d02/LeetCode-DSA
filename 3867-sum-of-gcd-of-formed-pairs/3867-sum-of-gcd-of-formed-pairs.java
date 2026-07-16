import java.util.Arrays;

class Solution {
    public long gcdSum(int[] nums) {
        int max = Integer.MIN_VALUE;
        int[] preficxGcd = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            preficxGcd[i] = gcd(max, nums[i]);
        }

        Arrays.sort(preficxGcd);
        int l = 0, r = nums.length-1;
        long gcdSum = 0;
        while (l < r){
            gcdSum += gcd(preficxGcd[l], preficxGcd[r]);
            l++;
            r--;
        }
        return gcdSum;
    }

    private int gcd(int a, int b){
        while (b != 0){
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }
}