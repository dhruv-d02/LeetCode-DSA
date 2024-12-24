import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        ArrayList<List<String>> ret = new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<>();
        for(String path : paths){
            String[] br = path.split(" ");
            //br[0] -> path
            //br[i] -> Filename(content)
            for (int i = 1; i < br.length; i++) {
                int conBreak = br[i].indexOf("(");
                String content = br[i].substring(conBreak+1, br[i].length()-1);
                map.putIfAbsent(content, new ArrayList<>());
                map.get(content).add(br[0] + "/" + br[i].substring(0, conBreak));
            }
        }
        for (Map.Entry<String , List<String>> entry : map.entrySet()){
            if(entry.getValue().size() > 1){
                ret.add(entry.getValue());
            }
        }
        return ret;
    }
}