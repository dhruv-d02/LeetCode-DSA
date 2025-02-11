class Solution {
    public String removeOccurrences(String s, String part) {
        if(s.contains(part)){
            int idx = s.indexOf(part);
            String ns = s.substring(0, idx) + s.substring(idx + part.length());
            return removeOccurrences(ns, part);
        }
        return s;
    }
}