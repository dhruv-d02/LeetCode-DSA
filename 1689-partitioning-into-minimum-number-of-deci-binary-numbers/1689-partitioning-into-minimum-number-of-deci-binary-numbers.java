class Solution {
    public int minPartitions(String n) {
        int max = 0;
        for(char c : n.toCharArray()){
            max = Math.max(max, Integer.parseInt(c + ""));
        }
        return max;
    }
}