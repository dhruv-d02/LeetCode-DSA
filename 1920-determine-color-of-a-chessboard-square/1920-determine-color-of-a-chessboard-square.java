class Solution {
    public boolean squareIsWhite(String coordinates) {

        //for char
        //even - black
        //odd - white
        //for number
        //odd - black
        //even - white

        //even odd black
        //odd even white

        char x1 = coordinates.charAt(0);
        int x = x1 - 'a';
        char y1 = coordinates.charAt(1);
        int y  = y1 - '1';

        if(x%2 == 0){
            if(y%2 == 0){
                return false;
            }
            return true;
        }
        else if(x%2 != 0){
            if(y%2 == 0){
                return true;
            }
            return false;
        }
        return true;
    }
}