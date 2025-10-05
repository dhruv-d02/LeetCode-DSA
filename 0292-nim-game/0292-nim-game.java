import java.io.StringReader;

class Solution {
    int[] possibilities;
    public boolean canWinNim(int n) {
        if(n<=3){
            return true;
        }
        return n%4 != 0;
    }
}
