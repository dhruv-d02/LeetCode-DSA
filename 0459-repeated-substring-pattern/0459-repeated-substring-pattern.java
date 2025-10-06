class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if(s.length() <2){
            return false;
        }
        int mid = s.length()/2;
        for(int i=mid; i>=0; i--){
            if(checkRepeat(s, i)){
                return true;
            }
        }
        return false;
    }

    private boolean checkRepeat(String s, int pos) {
        String toRepeat = s.substring(0, pos);
        if(toRepeat.length() == 0){
            return false;
        }
        if(s.length() % toRepeat.length() != 0){
            return false;
        }
        int cnt = s.length()/toRepeat.length();
        StringBuilder sb = new StringBuilder();
        while (cnt > 0){
            sb.append(toRepeat);
            cnt--;
        }
        return sb.toString().equals(s);
    }
}