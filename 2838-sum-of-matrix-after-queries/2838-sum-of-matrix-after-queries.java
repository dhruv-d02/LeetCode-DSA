class Solution {
    public long matrixSumQueries(int n, int[][] queries) {
        int rowSeenCnt = 0, colSeenCnt = 0;
        boolean[] rowSeen = new boolean[n];
        boolean[] colSeen = new boolean[n];
        long ans = 0;
        for(int i=queries.length-1; i>=0; i--)
        {
            int type = queries[i][0], index = queries[i][1], val = queries[i][2];
            
            if(type == 0 && !rowSeen[index])
            {
                rowSeenCnt++;
                rowSeen[index] = true;
                ans += (long) (n - colSeenCnt) *val;
            }
            if(type == 1 && !colSeen[index])
            {
                colSeenCnt++;
                colSeen[index] = true;
                ans += (long) (n - rowSeenCnt) *val;
            }
        }
        return ans;
    }
}