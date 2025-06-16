class Solution {
    public int maximumDifference(int[] arr) {
        int n = arr.length;
        int diff = -1;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(arr[j] > arr[i]){
                    diff = Math.max(diff, arr[j] - arr[i]);
                }
            }
        }
        return diff;
    }
}