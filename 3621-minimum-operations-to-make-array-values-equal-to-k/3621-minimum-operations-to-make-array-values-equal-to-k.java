

class Solution {
    public int minOperations(int[] nums, int k) {
        HashSet<Integer> map = new HashSet<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int n : nums)
        {
            min = Math.min(n, min);
            max = Math.max(n, max);
            map.add(n);
        }
        if(min < k)
            return -1;
        if(map.contains(k))
            return map.size() - 1;
        return map.size();
    }
}