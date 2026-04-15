import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(startIndex, 0));
        int[] vis = new int[words.length];
        int moves = Integer.MAX_VALUE;
        int n = words.length;
        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Pair poll = q.poll();
                if(vis[poll.idx] == 0) {
                    vis[poll.idx] = 1;
                    if(words[poll.idx].equals(target)){
                        return poll.moves;
                    }
                    q.add(new Pair((poll.idx+1)%n, poll.moves+1));
                    q.add(new Pair((poll.idx-1+n)%n, poll.moves+1));
                }
            }

        }
        return moves == Integer.MAX_VALUE ? -1 : moves;
    }
}

class  Pair{
    int idx;
    int moves;

    public Pair(int idx, int moves) {
        this.idx = idx;
        this.moves = moves;
    }
}