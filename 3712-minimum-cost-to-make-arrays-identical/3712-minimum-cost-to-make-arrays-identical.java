class Solution {
    public long minCost(int[] arr, int[] brr, long k) {
        int len = arr.length;

        long rawCost = 0;

        for(int i=0; i<len; i++)
        {
            rawCost += Math.abs((long) arr[i] - brr[i]);
        }

        long srt = k;
        Arrays.sort(arr);
        Arrays.sort(brr);
        for(int i=0; i<len; i++)
        {
            srt+= Math.abs((long) arr[i] - brr[i]);
        }

        return Math.min(rawCost, srt);
    }
}