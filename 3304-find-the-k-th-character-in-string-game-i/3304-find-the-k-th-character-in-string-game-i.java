class Solution {
    public char kthCharacter(int k) {
        StringBuilder sb = new StringBuilder("a");
        while (sb.length() < k){
            sb.append(findNext(sb.toString()));
        }
        return sb.charAt(k-1);
    }

    private String findNext(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            sb.append((char) (c+1));
        }
        return sb.toString();
    }
}