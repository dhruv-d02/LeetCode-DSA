import java.util.HashMap;
import java.util.Map;

class Solution {
    int mod=1000000007;
    public int lengthAfterTransformations(String s, int t) {
        if(t == 0)
            return s.length();
        long ans = 0;

        int[] cnt = new int[26];

        for(char c : s.toCharArray())
        {
            cnt[c-'a']++;
        }

        for(int i =0; i< t; i++)
        {
            int[] tempCnt = new int[26];
            for(int j=0; j<26; j++)
            {
                if(j == 25)
                {
                    tempCnt[0] = (tempCnt[0] + cnt[25])%mod;
                    tempCnt[1] = (tempCnt[1] + cnt[25])%mod;
                }
                else
                {
                    tempCnt[j+1] = (tempCnt[j+1] + cnt[j])%mod;
                }
            }
            cnt = tempCnt;
        }

        for(int i : cnt)
        {
            ans = (ans + i)%mod;
        }
        return (int)ans%mod;
    }
}