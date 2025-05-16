import java.util.Locale;

class Solution {
    public boolean isPalindrome(String s) {

        String ls = s.toLowerCase();

        int start = 0;
        int end = ls.length()-1;

        while (start < end)
        {
            char cs = ls.charAt(start);
            char es = ls.charAt(end);

            if(!((cs >= '0' && cs <= '9') || (cs >= 'a' && cs <= 'z')))
            {
                start++;
                continue;
            }

            if(!((es >= '0' && es <= '9') || (es >= 'a' && es <= 'z')))
            {
                end--;
                continue;
            }

            if(ls.charAt(start) != ls.charAt(end))
                return false;
            else{
                start++;
                end--;
            }

        }
        return true;
    }
}