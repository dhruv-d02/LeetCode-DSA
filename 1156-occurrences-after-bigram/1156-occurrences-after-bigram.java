import java.util.ArrayList;
import java.util.List;

class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        List<String> retList = new ArrayList<>();
        String[] splitArr = text.split(" ");
        for(int i=0; i<splitArr.length; i++){
            if(splitArr[i].equals(first)){
                if(i+1 < splitArr.length && splitArr[i+1].equals(second)){
                    if(i+2 < splitArr.length)
                        retList.add(splitArr[i+2]);
                }
            }
        }
        return retList.toArray(new String[retList.size()]);
    }
}