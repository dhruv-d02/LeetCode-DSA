class Solution {
    public int longestPalindrome(String[] words) {
        Map<String,Integer> map = new HashMap<>();
        int longest = 0;
        boolean oddPal = false;

        for (String word : words) {
            map.put(word, map.getOrDefault(word,0)+1);
        }

         for (Map.Entry<String,Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            int count = entry.getValue();

            if (count == 0) {
                continue;
            }

            if (isPal(key)) {
                if (count%2 == 0) {
                    longest+= count*2;
                    map.put(key,0);
                } else if (count>1) {
                    int toAdd = (count-1)*2;
                    longest+= toAdd;
                    map.put(key,0);
                    oddPal = true;
                } else {
                    oddPal = true;
                }
            } else {
                String reverted = revert(key);
                if (map.containsKey(reverted) && map.get(reverted)>0) {
                    int revertedCnt = map.get(reverted);
                    int maxCommon = Math.min(count,revertedCnt);
                    longest+=(maxCommon*4);
                    map.put(key,count-maxCommon);
                    map.put(reverted,revertedCnt-maxCommon);
                }
            }

        }

        if (oddPal) {
            longest+=2;
        }

        return longest;
    }

    public boolean isPal(String s) {
        return s.charAt(0) == s.charAt(1);
    }

    public String revert(String s) {
        char[] c = s.toCharArray();
        char[] c2 = new char[2];

        c2[0] = c[1];
        c2[1] = c[0];

        return new String(c2);
    }
}