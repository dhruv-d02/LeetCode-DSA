class Solution {
    public String smallestPalindrome(String s) {
        int[] freq = new int[26];
        int halfPoint = s.length()/2;

        int curr = 0;

        while(curr < halfPoint){
            freq[s.charAt(curr) - 'a']++;
            curr++;
        }

        char[] ret = new char[s.length()];

        int i=0, j= ret.length-1;

        for(int k=0; k<26; k++){
            int cnt = freq[k];
            while(cnt > 0){
                ret[i] = (char)(k+'a');
                ret[j] = (char)(k+'a');
                i++;
                j--;
                cnt--;
            }
        }
        if(s.length() % 2 != 0){
            ret[i] = s.charAt(curr);
        }

        return new String(ret);
    }
}