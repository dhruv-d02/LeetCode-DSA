class Solution {
    public int gcdOfOddEvenSums(int n) {
        int oddCnt = 0;
        int evenCnt = 0;
        int oddSum = 0;
        int evenSum = 0;
        int curr = 1;
        while(oddCnt < n || evenCnt < n){
            if(curr % 2 == 0){
                evenCnt++;
                evenSum += curr;
            }else{
                oddCnt++;
                oddSum += curr;
            }
            curr++;
        }
        return gcd(oddSum, evenSum);
    }

    private int gcd(int a, int b){
        while(b != 0){
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }
}