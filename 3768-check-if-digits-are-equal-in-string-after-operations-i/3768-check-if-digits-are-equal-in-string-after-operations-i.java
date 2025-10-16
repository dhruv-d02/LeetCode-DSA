class Solution {
    public boolean hasSameDigits(String s) {
        String newS = "";
        while (s.length() > 2){
            for(int i=0; i<s.length()-1; i++){
                int a = s.charAt(i) - '0';
                int b = s.charAt(i+1) - '0';
                char c = (char) (((a+b)%10) + '0');
                newS += c;
            }
            s = newS;
            newS = "";
        }
        return s.charAt(0) == s.charAt(1);
    }
}