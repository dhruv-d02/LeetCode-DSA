class Solution {
    public boolean checkDivisibility(int n) {
        long multiple = 1;
        long sum = 0;
        int m = n;
        while(n != 0){
            int d = n%10;
            n = n/10;
            sum += d;
            multiple *= d;
        }

        return m%(sum+multiple) == 0;
    }
}