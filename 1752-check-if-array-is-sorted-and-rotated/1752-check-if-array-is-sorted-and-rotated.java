class Solution {
    public boolean check(int[] arr) {
        boolean reversed = false;

        for(int i=1; i<arr.length; i++){
            if(arr[i-1] > arr[i]){
                if(reversed)
                    return false;
                reversed = true;
            }
        }
        if(arr[arr.length-1] > arr[0] && reversed){
            return false;
        }
        return true;
    }
}