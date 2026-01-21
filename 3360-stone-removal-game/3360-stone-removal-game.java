class Solution {
    public boolean canAliceWin(int n) {
        boolean aliceTurn = true;
        int curr = 10;
        while (n > 0){
            if(curr <= n){
                n -= curr;
                curr--;
                aliceTurn = !aliceTurn;
            }else{
                break;
            }
        }
        return !aliceTurn;
    }
}