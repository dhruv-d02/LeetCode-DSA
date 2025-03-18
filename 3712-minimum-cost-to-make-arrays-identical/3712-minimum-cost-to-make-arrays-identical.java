class Solution {
    public long minCost(int[] arr, int[] brr, long k) {
        int len = arr.length;

        long rawCost = 0;

        for(int i=0; i<len; i++)
        {
            rawCost += Math.abs((long) arr[i] - brr[i]);
        }

        long srt = k;
        int[] at = arr.clone();
        int[] bt = brr.clone();
        Arrays.sort(at);
        Arrays.sort(bt);
        for(int i=0; i<len; i++)
        {
            srt+= Math.abs((long) at[i] - bt[i]);
        }

        return Math.min(rawCost, srt);
    }
}