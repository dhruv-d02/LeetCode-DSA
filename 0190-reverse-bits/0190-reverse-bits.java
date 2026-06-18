class Solution {
    public int reverseBits(int n) {
        String bits = String.format("%32s",
            Integer.toBinaryString(n))
            .replace(' ', '0');

        String reversed = new StringBuilder(bits)
                .reverse()
                .toString();

        return (int) Long.parseLong(reversed, 2);
    }
}