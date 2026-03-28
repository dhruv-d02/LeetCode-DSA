class Solution {
    public boolean judgeSquareSum(int c) {
        if(c == 0){
            return true;
        }
        for(int i=0; i<Math.sqrt(c); i++){
            int x = c- i*i;
            if(x%Math.sqrt(x) == 0){
                return true;
            }
        }
        return false;
    }
}