class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        int cnt = 1;
        char prev = s.charAt(0);
        sb.append(prev);
        for (int i = 1; i < s.length(); i++) {
            if(prev == s.charAt(i)) {
                cnt++;
            }else{
                prev = s.charAt(i);
                cnt = 1;
            }
            if(cnt >= 3){
                continue;
            }
            sb.append(prev);
        }
        return sb.toString();
    }
}