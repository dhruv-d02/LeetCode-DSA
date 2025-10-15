class Solution {
    public long smallestNumber(long num) {
        boolean neg = false;
        if(num == 0)
            return 0;
        if(num < 0){
            neg = true;
            num = num*(-1);
        }
        int[] digits = new int[10];
        while (num != 0){
            int rem = (int) (num%10);
            digits[rem]++;
            num = num/10;
        }
        long ans = 0;
        if(neg){
            for(int i=9; i>=0; i--){
                while (digits[i] != 0) {
                    ans = ans * 10 + i;
                    digits[i]--;
                }
            }
        }else{
            for(int i=1; i<=9; i++){
                if(digits[i] !=  0){
                    ans = ans*10 + i;
                    digits[i]--;
                    break;
                }
            }
            for(int i=0; i<=9; i++){
                while (digits[i] !=  0){
                    ans = ans*10 + i;
                    digits[i]--;
                }
            }
        }
        if(neg){
            return ans *(-1);
        }
        return ans;
    }
}