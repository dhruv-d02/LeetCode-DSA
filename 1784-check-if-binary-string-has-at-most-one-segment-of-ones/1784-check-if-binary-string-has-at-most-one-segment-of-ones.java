class Solution {
    public boolean checkOnesSegment(String s) {
        int seg = 0;
        if(s.charAt(0) == '1')
            seg++;
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i) == '1' && s.charAt(i-1) == '0'){
                seg++;
            }
        }
        return seg == 1;
    }
}