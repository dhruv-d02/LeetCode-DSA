class Solution {
    public long pickGifts(int[] gifts, int k) {
        Arrays.sort(gifts);
        int i = k;
        while (i>0){
            gifts[gifts.length-1] = (int) Math.sqrt(gifts[gifts.length-1]);
            Arrays.sort(gifts);
            i--;
        }
        long ans = 0;
        for (i = 0; i < gifts.length; i++) {
            ans += gifts[i];
        }
        return ans;
    }
}