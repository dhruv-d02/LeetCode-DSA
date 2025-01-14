import java.util.HashMap;

class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] ans = new int[A.length];

        HashMap<Integer, Boolean> mapA = new HashMap<>();
        HashMap<Integer, Boolean> mapB = new HashMap<>();
        for (int i=0; i<A.length; i++){
            mapA.put(A[i], true);
            mapB.put(B[i],true);
            if(i==0){
                if(A[i] == B[i]){
                    ans[i] =  1;
                }else{
                    ans[i] = 0;
                }
            }
            else{
                ans[i] = ans[i-1];
                if(mapB.getOrDefault(A[i], false)){
                    ans[i] += 1;
                }
                if(mapA.getOrDefault(B[i], false)){
                    ans[i] += 1;
                }
                if(A[i] == B[i]){
                    ans[i] -= 1;
                }
            }
        }

        return ans;
    }
}