class Solution {
    public int maxScore(String s) {
        int n = s.length();
        int ret = 0;
        for(int i=1;i<n; i++){
            String left = s.substring(0,i);
            String right = s.substring(i,n);
            int zero = 0, one = 0;
            int z = 0;
            while(z<left.length()){
                if(left.charAt(z) == '0'){
                    zero++;
                }
                z++;
            }
            z = 0;
            while(z<right.length()){
                if(right.charAt(z) == '1'){
                    one++;
                }
                z++;
            }

            ret = Math.max(ret, one + zero);
        }
        return ret;
    }
}