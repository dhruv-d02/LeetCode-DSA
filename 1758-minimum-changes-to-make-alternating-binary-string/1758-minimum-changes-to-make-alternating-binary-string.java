import java.util.Map;

class Solution {
    public int minOperations(String s) {
        boolean change = s.charAt(0) ==  '0' ? false : true;
        StringBuilder pattern1 = new StringBuilder();
        StringBuilder pattern2 = new StringBuilder();
        for(int i=0; i<s.length(); i++) {
            if (change) {
                pattern1.append('1');
                pattern2.append('0');
            }
            else {
                pattern1.append('0');
                pattern2.append('1');
            }
            change = !change;
        }
        int cnt1 = 0;
        int cnt2 = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) != pattern1.charAt(i))
                cnt1++;
            if(s.charAt(i) != pattern2.charAt(i))
                cnt2++;
        }
        return Math.min(cnt1, cnt2);
    }
}