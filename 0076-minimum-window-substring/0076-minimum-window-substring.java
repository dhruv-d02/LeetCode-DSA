import java.util.HashMap;
import java.util.Map;

class Solution {
    public String minWindow(String s, String t) {
        String  ans = "";
        if(t.length() > s.length()){
            return "";
        }

        int[] freqT = new int[52]; // 0–25 for 'A'-'Z', 26–51 for 'a'-'z'
        for (char ch : t.toCharArray()) {
            freqT[getPos(ch)]++;
        }


        for(int start=0; start<s.length() - t.length()+1; start++){

            int curr = start + t.length();
            while (curr < s.length()+1){
                String ns = s.substring(start, curr);
                if(!ans.equals("") && ns.length() > ans.length()){
                    break;
                }
                if(valid(ns, freqT)){
                    if(ans.equals("") || ans.length() > ns.length()){
                        ans = ns;
                    }
                    break;
                }
                curr++;
            }
        }
        return ans;
    }

    private int getPos(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            return ch - 'A';
        } else if (ch >= 'a' && ch <= 'z') {
            return 26 + ch - 'a';
        }
        return -1;
    }

    private boolean valid(String s, int[] freqT) {
        int[] freqS = new int[52];

        for(int i=0; i<s.length(); i++){
            freqS[getPos(s.charAt(i))]++;
        }

        for(int i=0; i<52; i++){
            if(freqS[i] < freqT[i]){
                return false;
            }
        }

        return true;
    }
}