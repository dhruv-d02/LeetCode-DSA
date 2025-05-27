class Solution {
    public int differenceOfSums(int n, int m) {
        int k = n/m; //count of how many numbers are there as multiple of m in [1,n];
        return ((n * (n + 1)) / 2) - (m * k * (k + 1)); //Sum of n numbers - 2*sum of AP with difference m

        //3+6+9 => 3(1+2+3) => 3*(3*(3+1)/2)
        //Multiplied by 2 because it's sum was added in Sum of n numbers as well so subtracting it twice;
    }
}