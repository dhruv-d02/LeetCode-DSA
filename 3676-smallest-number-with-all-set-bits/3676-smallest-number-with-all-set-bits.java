class Solution {
    public int smallestNumber(int n) {
        while (true){
            String bitString = Integer.toBinaryString(n);
            if(!bitString.contains("0")){
                return n;
            }
            n++;
        }
    }
}