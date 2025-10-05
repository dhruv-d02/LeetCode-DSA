import java.io.StringReader;

class Solution {
    public String convertToTitle(int n) {
        if(n==0){
            return "Z";
        }
        if(n <= 26){
            return (char)('A'+n-1) + "";
        }
        if(n%26 == 0){
            return convertToTitle(n/26 - 1) + 'Z';
        }
        String ret = convertToTitle(n/26)+ convertToTitle(n%26);
        return ret;
    }
}
