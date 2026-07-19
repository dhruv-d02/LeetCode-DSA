class Solution {
    public String smallestSubsequence(String s) {
        int[] last = new int[26];
        boolean[] present = new boolean[26];

        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        StringBuilder sb = new StringBuilder();


        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);

            if(present[c - 'a'])
                continue;

            while (sb.length() > 0 && sb.charAt(sb.length() - 1) > c && last[sb.charAt(sb.length() - 1) - 'a'] > j){
                present[sb.charAt(sb.length()-1) - 'a'] = false;
                sb.deleteCharAt(sb.length()-1);
            }

            sb.append(c);
            present[c-'a'] = true;
        }

        return sb.toString();
    }
}