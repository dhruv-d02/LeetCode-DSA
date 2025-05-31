import java.util.*;

class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        if(n*n <= 6){
            return 1;
        }

        int[] min_rolls = new int[(n+1)*(n+1)];
        Arrays.fill(min_rolls, -1);
        min_rolls[1] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);

        while (!queue.isEmpty()){
            int top = queue.poll();

            for(int i=1; i<=6 && top + i <= n*n; i++){
                int curr = top+i;
                int row = (curr-1)/n;
                int col = (curr-1)%n;
                int boardVal = board[n-1-row][row%2==0 ? col : n-1-col];
                int to = boardVal > 0 ? boardVal : curr;
                if(to == n*n) return min_rolls[top] + 1;
                if(min_rolls[to] == -1){
                    min_rolls[to] = min_rolls[top] + 1;
                    queue.offer(to);
                }
            }
        }
        return -1;
    }

}