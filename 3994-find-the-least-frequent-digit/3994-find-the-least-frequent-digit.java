class Solution {
    public int getLeastFrequentDigit(int n) {
        int[] digits = new int[10];
        while (n != 0){
            int rem = n%10;
            n = n/10;
            digits[rem]++;
        }
        int ans = 0;
        for(int i=0; i<digits.length; i++){
            if(digits[i] == 0){
                continue;
            }
            if(digits[ans] == 0){
                ans = i;
            }
            if(digits[ans] == digits[i]){
                ans = Math.min(ans, i);
            }
            if(digits[ans] > digits[i]){
                ans = i;
            }

        }
        return ans;
    }
}