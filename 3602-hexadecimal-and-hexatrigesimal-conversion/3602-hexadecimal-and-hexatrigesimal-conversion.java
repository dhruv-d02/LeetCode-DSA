class Solution {
    public String concatHex36(int n) {
        String hex = convert(n*n, 16);
        String tri = convert(n*n*n,  36);
        return hex + tri + "";
    }

    private String convert(int num, int var) {
        StringBuilder ans = new StringBuilder();
        while (num > 0){
            int rem = num%var;
            if(rem >=0 && rem <=9){
                ans.insert(0,rem);
            }else{
                rem -= 10;
                char c = (char) ('A'+rem);
                ans.insert(0, c);
            }
            num = num/var;
        }
        return ans.toString();
    }
}