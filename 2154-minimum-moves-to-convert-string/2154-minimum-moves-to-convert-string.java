class Solution {
    public int minimumMoves(String s) {
        int moves = 0;
        int pos = 0;
        while (pos < s.length()){
            if(s.charAt(pos) == 'X'){
                moves++;
                pos+=3;
            }else {
                pos++;
            }
        }
        return moves;
    }
}