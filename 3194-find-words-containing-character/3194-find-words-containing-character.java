class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> indexs = new ArrayList<>();
        int idx = 0;
        for(String word : words){
            if(word.indexOf(x) != -1)
                indexs.add(idx);
            idx++;
        }
        return indexs;
    }
}