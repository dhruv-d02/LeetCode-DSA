class Solution {
    public int trap(int[] height) {
        int [] prev = getPrev(height); 
        int [] next = getNext(height);
        // for(int i : next){
        //     System.out.print(i + " ");
        // } 
        int n = height.length;
        int ret = 0;
        for(int i=0; i<n; i++){
            ret += Math.min(prev[i], next[i]) - height[i];
        }
        return ret;
    }
    private int[] getPrev(int[] height){
        int n = height.length;
        int[] ret = new int[n];
        int prev = 0;
        for(int i=0; i<n; i++){
            prev = prev < height[i] ? height[i] : prev;
            ret[i] = prev; 
        }
        return ret;
    }
    private int[] getNext(int[] height){
        int n = height.length;
        int[] ret = new int[n];
        int prev = 0;
        for(int i=n-1; i>=0; i--){
            prev = prev < height[i] ? height[i] : prev;
            ret[i] = prev; 
        }
        return ret;
    }
}