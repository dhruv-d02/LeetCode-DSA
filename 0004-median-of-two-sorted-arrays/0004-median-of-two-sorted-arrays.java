class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int [] a = new int[m+n];

        int i=0, j=0, k=0;
        while(i<m && j<n){
            a[k++] = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
        }
        while(i < m){
            a[k++] = nums1[i++];
        }
        
        while(j < n){
            a[k++] = nums2[j++];
        }

        int len = a.length;
        if(len%2 == 0){
            int c = len/2 -1;
            int d = len/2;
            //System.out.println(c + " "+ d + a[c] + " "+ a[d]);
            return (a[c] + a[d])/2.0;
        }
        // System.out.println(len/2 + " "+ a[len/2]);
        return a[len/2];
    }
}