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
                String[] conBreak = br[i].split("\\(");
                String content = conBreak[1].substring(0, conBreak[1].length()-1);
                if(map.get(content) == null){
                    map.put(content, new ArrayList<>());
                }
                map.get(content).add(br[0] + "/" + conBreak[0]);
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