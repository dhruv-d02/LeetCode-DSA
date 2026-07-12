class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] cpy = arr.clone();

        Arrays.sort(cpy);

        HashMap<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        for(int c : cpy){
            if(map.get(c) == null)
                map.putIfAbsent(c, rank++);
        }

        for(int i=0; i<arr.length; i++){
            cpy[i] = map.get(arr[i]);
        }    
        return cpy;
    }
}