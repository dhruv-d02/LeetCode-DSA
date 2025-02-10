import java.util.HashMap;

class Solution {
    public String clearDigits(String s) {
        if(s.isEmpty()){
            return "";
        }
        StringBuilder sb = new StringBuilder(s);
        int i=0;
        while (i<s.length() && sb.charAt(i) >='a' && sb.charAt(i) <= 'z'){
            i++;
        }
        if(i==s.length()){
            return s;
        }
        String ns = sb.substring(0, i-1)+ sb.substring(i+1);
        if(s.equals(ns)){
            return ns;
        }
        return clearDigits(ns);
    }
}