class Solution {
    public int[] minOperations(String boxes) {
        int[] ans = new int[boxes.length()];
        int sum = 0;
        int cnt = 0;
        //prefix and suffix sum
        for(int i=boxes.length()-1; i>=0; i--){
            sum += cnt;
            ans[i] += sum;
            if(boxes.charAt(i) == '1'){
                cnt+=1;
            }
        }
        sum = 0;
        cnt = 0;
        for(int i=0; i<boxes.length(); i++){
            sum += cnt;
            ans[i] += sum;
            if(boxes.charAt(i) == '1'){
                cnt+=1;
            }
        }
        return ans;
    }
}