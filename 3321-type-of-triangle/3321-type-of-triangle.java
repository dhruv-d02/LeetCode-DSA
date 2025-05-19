class Solution {
    public String triangleType(int[] nums) {
        int a = nums[0];
        int b = nums[1];
        int c = nums[2];
        if(a+b <= c){
            return "none";
        }
        if(a+c <= b){
            return "none";
        }
        if(b+c <= a){
            return "none";
        }
        if(a != b && b != c && a != c){
            return "scalene";
        }
        if(a == b && b == c){
            return "equilateral";
        }
        if(a==b && b != c){
            return "isosceles";
        }
        if(a!=b && b==c){
            return "isosceles";
        }
        if(a!=b && a==c){
            return "isosceles";
        }
        return "none";
    }
}