class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> indexs = new ArrayList<>();
        int idx = 0;
        for(String word : words){
            if(word.contains(x+""))
                indexs.add(idx);
            idx++;
        }
        return indexs;
    }
}