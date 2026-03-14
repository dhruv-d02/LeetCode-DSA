import java.util.ArrayList;
import java.util.List;

class Solution {
    char[] usedChars = new char[]{'a', 'b', 'c'};
    public String getHappyString(int n, int k) {
        List<String> happyStrings = new ArrayList<>();
        helper(n, happyStrings, new StringBuilder());
        return happyStrings.size()>=k ? happyStrings.get(k-1) : "";
    }

    private void helper(int n, List<String> k, StringBuilder curr) {
        if(curr.length() == n){
            k.add(curr.toString());
            return;
        }
        for (int i = 0; i <usedChars.length; i++) {
            if(!curr.isEmpty() && curr.charAt(curr.length() - 1) == usedChars[i])
            {
                continue;
            }
            curr.append(usedChars[i]);
            helper(n, k, curr);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}