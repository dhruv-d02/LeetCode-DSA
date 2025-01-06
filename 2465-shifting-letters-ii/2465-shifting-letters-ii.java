class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] diff = new int[n+1];
        for(int[] shift : shifts){
            if(shift[2] == 1){
                diff[shift[0]] += 1;
                diff[shift[1] + 1] -= 1;
            }else{
                diff[shift[0]] -= 1;
                diff[shift[1] + 1] += 1;
            }
        }
        int total = 0;
        for(int i=1; i<n+1; i++){
            diff[i] += diff[i-1];
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            int cnt = diff[i]%26;
            if(cnt < 0){
                cnt += 26;
            }
            char c = (char) ((s.charAt(i)-'a' + cnt)%26 +'a');
            sb.append(c);
        }
        return sb.toString();
    }
}