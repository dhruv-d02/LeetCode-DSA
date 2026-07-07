class Solution {
    public long sumAndMultiply(int n) {
        String s = n + "";
        long sum = 0;
        long newNum = 0;
        for(char c : s.toCharArray()){
            if(c-'0' > 0){
                long t = c-'0';
                sum += t;
                newNum = newNum*10 + t;
            }
        }
        return sum*newNum;
    }
}