import java.util.*;

class Solution {
    class Robot{
        int position;
        int health;
        char dir;
        boolean rem;

        public Robot(int position, int health, char dir) {
            this.position = position;
            this.health = health;
            this.dir = dir;
            this.rem = true;
        }
    }
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        TreeMap<Integer, Robot> map = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        for (int i = 0; i < positions.length; i++) {
            map.put(positions[i], new Robot(positions[i], healths[i], directions.charAt(i)));
        }
        Stack<Robot> robotsMovement = new Stack<>();
        for(Map.Entry<Integer, Robot> entry : map.entrySet()){
            collide(entry.getValue(),robotsMovement);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int pos : positions){
            Robot r = map.get(pos);
            if(r.rem) {
                ans.add(r.health);
            }
        }
        return ans;
    }

    private void collide(Robot robot, Stack<Robot> robotsMovement) {

        if(robotsMovement.isEmpty()) {
            robotsMovement.add(robot);
            return;
        }

        while (!robotsMovement.isEmpty()){
            Robot r = robotsMovement.pop();

            if(r.dir == robot.dir){
                robotsMovement.add(r);
                robotsMovement.add(robot);
                break;
            }
            if(r.dir == 'L' && robot.dir == 'R'){
                robotsMovement.add(r);
                robotsMovement.add(robot);
                break;
            }
            if(r.health > robot.health){
                r.health -= 1;
                robot.rem = false;
                robotsMovement.add(r);
                break;
            }else if(r.health == robot.health){
                robot.rem = false;
                r.rem = false;
                break;
            }else{
                r.rem = false;
                robot.health -= 1;
            }
        }
    }
}