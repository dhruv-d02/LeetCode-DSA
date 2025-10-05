class Solution {
    public int minimumMoves(String s) {
        int moves = 0;

        for(int i=0; i<s.length();){
            if(s.charAt(i) != 'X'){
                i++;
                continue;
            }
            int Xcnt = 0;
            for (int j=0; j<3 && i+j<s.length(); j++){
                if(s.charAt(i+j) ==  'X'){
                    Xcnt++;
                }
            }
            if(Xcnt != 0){
                moves++;
            }
            i+=3;
        }
        return moves;
    }
}