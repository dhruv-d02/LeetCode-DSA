import java.util.HashMap;

class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] res = new int[A.length];

        HashMap<Integer, Boolean> mapA = new HashMap<>();
        HashMap<Integer, Boolean> mapB = new HashMap<>();
        for(int i=0; i<A.length; i++){
            mapA.put(A[i], true);
            mapB.put(B[i], true);
            if(mapA.getOrDefault(B[i], false)){
                res[i]++;
            }
            if(mapB.getOrDefault(A[i], false)){
                res[i]++;
            }
            if(A[i] == B[i]){
                res[i]--;
            }
            if(i>0){
                res[i] += res[i-1];
            }
        }
        return res;
    }
}