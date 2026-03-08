class Solution {
    public int minFlips(String target) {
        int count = 0;
        char  expected = '0';

        for(int i=0; i<target.length(); i++){
            if(target.charAt(i) != expected){
                count++;
                expected = target.charAt(i);
            }
        }
        return count;
    }
}