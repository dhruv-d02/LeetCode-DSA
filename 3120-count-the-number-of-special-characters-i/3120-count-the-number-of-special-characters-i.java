class Solution {
    public int numberOfSpecialChars(String word) {
        int[] cntC = new int[26];
        int[] cntc = new int[26];

        for(char c : word.toCharArray()){
            if(c >= 'A' && c <= 'Z'){
                cntC[c-'A']++;
            }
            if(c >= 'a' && c <= 'z'){
                cntc[c-'a']++;
            }
        }

        int res = 0;
        for(int i=0; i<26; i++){
            if(cntc[i] > 0 && cntC[i] > 0){
                res++;
            }
        }
        return res;
    }
}