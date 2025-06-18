class Solution {
    public int[][] divideArray(int[] nums, int k) {
        ArrayList<int[]> ret = new ArrayList<>();
        int n = nums.length;
        int[][] x = new int[n/3][3];
        Arrays.sort(nums);
        for(int i=0; i<n; i+=3){
            int a = nums[i];
            int b = nums[i+1];
            int c = nums[i+2];
            // System.out.println(a + " "+ b+ " "+ c);
            // System.out.println(Math.abs(a-b) + " "+ Math.abs(a-c) + " "+ Math.abs(c-b));
            if(Math.abs(a-b) > k || Math.abs(a-c) > k || Math.abs(c-b) > k)
            {
                // ret.clear();
                // break;
                return new int[][] {};
            }
            // int[] temp = new int[] {a, b ,c};
            // ret.add(temp);
            x[i/3][0] = a;
            x[i/3][1] = b;
            x[i/3][2] = c;
        }
        // System.out.println(nums);
        // return ret.toArray(new int[ret.size()][3]);
        return x;
    }
}