import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Queue<Integer> q = new LinkedList<>();
        Arrays.sort(asteroids);
        for (int a : asteroids)
            q.add(a);

        long newMass = mass;
        int round = 0;
        int cnt = 0;
        while (!q.isEmpty()){
            if(round > 5)
                break;
            int ast = q.poll();
            if(newMass >= ast) {
                newMass += ast;
            }else{
                q.add(ast);
            }
            cnt++;
            if(cnt == asteroids.length) {
                cnt = 0;
                round++;
            }
        }
        return q.isEmpty();
    }
}