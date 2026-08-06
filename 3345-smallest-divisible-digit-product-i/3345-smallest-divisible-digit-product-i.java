class Solution {
    public int smallestNumber(int n, int t) {
        
        int mul = getDigitMultiply(n);
        int remaining = getDigitMultiply(n/10);
        int last = n%10;
        
        while (true){
            if(mul%t == 0){
                return n;
            }
            n++;
            last++;
            if(last <= 9){
                mul = remaining*last;
            }else{
                mul = getDigitMultiply(n);
                remaining = getDigitMultiply(n/10);
                last = 0;
            }
        }
    }

    private int getDigitMultiply(int n) {
        int mul = 1;
        while (n!=0){
            mul *= n%10;
            n = n/10;
        }
        return mul;
    }
}