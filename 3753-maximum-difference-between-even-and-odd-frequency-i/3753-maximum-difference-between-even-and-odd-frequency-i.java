class Solution {
    public int maxDifference(String s) {
        int[] cnt = new int[26];
        int maxOdd = Integer.MIN_VALUE;
        int minEven = Integer.MAX_VALUE;

        for(char c : s.toCharArray()){
            cnt[c-'a']++;
        }

        for(int i=0; i<26; i++){
            if(cnt[i] == 0){
                continue;
            }
            if(cnt[i]%2 == 0){
                minEven = Math.min(minEven, cnt[i]);
            }else {
                maxOdd = Math.max(maxOdd, cnt[i]);
            }
        }
        return maxOdd-minEven;

    }
}