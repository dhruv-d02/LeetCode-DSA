class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0, sum2=0;
        long cnt1 = 0, cnt2 = 0;
        for(int i : nums1) {
            if(i==0)
                cnt1++;
            sum1 += i;
        }
        for (int i : nums2) {
            if(i==0)
                cnt2++;
            sum2 += i;
        }
        long min1 = sum1 + cnt1;
        long min2 = sum2 + cnt2;
        if(cnt1 == 0 && cnt2 == 0)
            return min1 == min2 ? min1 : -1;
        if(cnt1 == 0)
        {
            return min2 <= sum1 ? sum1 : -1;
        }
        if(cnt2 == 0)
            return min1 <= sum2 ? sum2 : -1;
        return Math.max(min1, min2);
    }
}