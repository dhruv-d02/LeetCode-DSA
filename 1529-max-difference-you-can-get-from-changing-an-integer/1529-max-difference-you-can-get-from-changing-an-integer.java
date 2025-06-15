class Solution {
    public int maxDiff(int num) {
        StringBuilder max = new StringBuilder(num+"");
        StringBuilder min = new StringBuilder(num+"");

        char maxChartoReplace = ' ';
        char minChartoReplace =' ';
        for(int i=0; i<max.length(); i++){
            if(max.charAt(i) != '9'){
                maxChartoReplace = max.charAt(i);
                break;
            }
        }

        for (int i=0; i<max.length(); i++){
            if(max.charAt(i) == maxChartoReplace){
                max.setCharAt(i, '9');
            }
        }

        boolean setToZero = false;
        for(int i=0; i<min.length(); i++) {
            if (min.charAt(i) != '0' && min.charAt(i) != '1') { 
                if(i!= 0){
                    setToZero = true;
                }
                minChartoReplace = min.charAt(i);
                break;
            }
        }

        for(int i=0; i<min.length(); i++){
            if(min.charAt(i) == minChartoReplace){
                min.setCharAt(i, setToZero ? '0' : '1');
            }
        }


        return Integer.parseInt(max.toString()) - Integer.parseInt(min.toString());
    }

}