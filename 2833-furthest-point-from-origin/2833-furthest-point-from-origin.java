class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int cL=0, cR=0;
        int n = moves.length();
        int ans=0;
        for(int i=0; i<n; i++) {
            if(moves.charAt(i)=='L'){
                cL++;
            }
            else if(moves.charAt(i)=='R') {
                cR++;
            }
        }
        
        if(cL>cR) {
            ans = cL-cR;
        }
        else {
            ans = cR-cL;
        }
        
        ans += (n-cR-cL);
        
        return ans;
    }
}