class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if(m%2 == 0 && n%2 == 0)
            return 0;
        // int[] ret = new int[a*b];
        int k = 0;
        int ans = 0;
        int a = 0;
        int b = 0;
        for(int i : nums1){
            a = a^i;
        }
        for(int i : nums2){
            b = b^i;
        }
        // int ans = 0;
        // for(int i : ret){
        //     ans = ans^i;
        //     // System.out.print(i + " ");
        // }
        if(m%2 == 0)
            return a;
        if(n%2 == 0)
            return b;
        return a^b;
    }
}
