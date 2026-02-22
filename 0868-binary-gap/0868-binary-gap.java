class Solution {
    public int binaryGap(int n) {
        String binary = toBinary(n);
        int prev = -1;
        int ans = 0;
        for(int i=0; i<binary.length(); i++){
            if(binary.charAt(i) == '1'){
                if(prev == -1){
                    prev = i;
                }else{
                    ans = Math.max(ans, i-prev);
                    prev = i;
                }
            }
        }
        return ans;
    }

    private String toBinary(int n) {
        StringBuilder binary = new StringBuilder();
        while (n != 1){
            int rem = n%2;
            n = n/2;
            binary.insert(0, rem);
        }
        binary.insert(0, '1');
        return binary.toString();
    }
}