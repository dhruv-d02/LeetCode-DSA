class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        HashMap<String, Boolean> dic = new HashMap<>();
        List<String> ret = new ArrayList<>();
        for(String s : dictionary){
            dic.put(s, true);
        }
        for(String q : queries){
            if(isValid(q, dic)){
                ret.add(q);
            }
        }
        return ret;
    }

    private boolean isValid(String word, HashMap<String, Boolean> dic){
        if(dic.get(word) != null){
            return true;
        }

        // int[] w = new int[26];
        // for(int i=0; i<word.length(); i++){
        //     w[s.charAt(i) - 'a']++;
        // }
        for(Map.Entry<String, Boolean> entry : dic.entrySet()){
            String s = entry.getKey();
            int diff = 0;
            if(s.length() != word.length())
                continue;
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i) != word.charAt(i)){
                    diff++;
                    if(diff > 2){
                        break;
                    }
                }
            }
            if(diff <= 2){
                return true;
            }
        }
        return false;
    }
}