class Solution {
    public int maximumLength(String s) {
        List<String> subArrays = new ArrayList<>();
        for(int i=0; i<s.length(); i++){
            int curr = i;
            while (curr < s.length() && s.charAt(curr) == s.charAt(i)){
                subArrays.add(s.substring(i, curr+1));
                curr++;
            }
        }
        Map<String, Integer> map = new HashMap<>();

        for (String st : subArrays){
            map.put(st, map.getOrDefault(st, 0)+1);
        }

        int maxValue = 0;
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(entry.getValue() >= 3){
                maxValue = Math.max(entry.getKey().length(), maxValue);
            }
        }
        return maxValue == 0 ? -1 : maxValue;
    }
}