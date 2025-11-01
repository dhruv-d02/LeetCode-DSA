class Solution {
    public int characterReplacement(String s, int k) {
        int ans = 0;
        int n = s.length();
        for (char c = 'A'; c <= 'Z'; c++) {
            int start = 0, currr = 0, replaced = 0;
            while (currr < n) {
                if (s.charAt(currr) == c) {
                    currr++;
                }
                else{
                    if(replaced < k){
                        replaced++;
                        currr++;
                    }else{
                        if(s.charAt(start) != c){
                            replaced--;
                        }
                        start++;
                    }
                }
                ans = Math.max(ans, currr - start);
            }
        }
        return ans;
    }
}