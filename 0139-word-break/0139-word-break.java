import java.util.List;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true;
        for(int i=s.length()-1; i>=0; i--)
        {
            for(String w : wordDict)
            {
                if(i+ w.length() <= s.length())
                {
                    if(w.equals( s.substring(i, i+w.length())))
                        dp[i] = dp[i+w.length()];
                }
                if(dp[i])
                    break;
            }
        }
        return dp[0];
    }
}