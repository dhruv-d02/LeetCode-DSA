class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1)
            return strs[0];
        String prefix = "";
        String a = strs[0];
        String b = strs[1];
        for(int i=0; i< Math.min(a.length(), b.length()); i++)
        {
            if(a.charAt(i) == b.charAt(i))
                prefix += a.charAt(i);
            else
                break;
        }
        if(prefix.isEmpty())
            return "";

        for(int i=2; i<strs.length; i++)
        {
            if(strs[i].isEmpty())
                return "";
            String checkPrefix = strs[i].substring(0, Math.min(prefix.length(), strs[i].length()));
            if(checkPrefix.equals(prefix))
                continue;
            int newLength = 0;
            while (newLength < Math.min(prefix.length(), checkPrefix.length()))
            {
                if(prefix.charAt(newLength) == checkPrefix.charAt(newLength))
                {
                    newLength++;
                }
                else
                {
                    break;
                }
            }
            if(newLength == 0)
            {
                return "";
            }
            prefix = prefix.substring(0, newLength);
        }
        return prefix;
    }
}