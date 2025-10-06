import java.util.HashMap;
import java.util.Map;

class Solution {
    public int winningPlayerCount(int n, int[][] pick) {
        Map<Integer, int[]> players = new HashMap<>();
        for(int i=0; i<=n; i++){
            players.put(i, new int[11]);
        }
        int winCnt = 0;
        for(int i=0; i<pick.length; i++){
            if(players.containsKey(pick[i][0])) {
                players.get(pick[i][0])[pick[i][1]]++;
                if (players.get(pick[i][0])[pick[i][1]] > pick[i][0]) {
                    winCnt++;
                    players.remove(pick[i][0]);
                }
            }
        }
        return winCnt;
    }
}