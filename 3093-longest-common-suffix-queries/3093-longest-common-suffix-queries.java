import com.sun.jdi.connect.AttachingConnector;

import javax.sql.rowset.spi.SyncResolver;
import java.util.*;

class Solution {
    HashMap<String, List<Integer>> map;
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        TrieNode root = new TrieNode();
        map = new HashMap<>();
        for (int i=0; i<wordsContainer.length; i++){
            root.add(wordsContainer[i]);
            root.stringList.add(wordsContainer[i]);
            if(map.get(wordsContainer[i]) == null)
                map.put(wordsContainer[i], new ArrayList<>());
            map.get(wordsContainer[i]).add(i);
        }

        int[] ret = new int[wordsQuery.length];

        for (int i=0; i<wordsQuery.length; i++){
            String res = root.query(wordsQuery[i]);
            ret[i] = map.get(res).get(0);
        }

        return ret;
    }
    class TrieNode{
        TrieNode[] nodes;
        ArrayList<String> stringList;

        public TrieNode() {
            nodes = new TrieNode[26];
            stringList = new ArrayList<>();
        }

        public void add(String s){
            add(s, s.length()-1);
        }

        private void add(String s, int pos){
            if(pos <0){
                return;
            }
            if(this.nodes[s.charAt(pos)-'a'] == null){
                this.nodes[s.charAt(pos)-'a'] = new TrieNode();
            }
            this.nodes[s.charAt(pos)-'a'].add(s, pos-1);
            this.nodes[s.charAt(pos)-'a'].stringList.add(s);
        }

        public String query(String q) {
            TrieNode lastNodeFound = query(q, q.length());
            if(lastNodeFound == null){
                //no suffix found
                lastNodeFound = this;
            }

            lastNodeFound.stringList.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.length() - o2.length();
                }
            });
            String min = lastNodeFound.stringList.get(0);

            for(int i=0; i<lastNodeFound.stringList.size(); i++){
                String s = lastNodeFound.stringList.get(i);
                if(min.length() > s.length()){
                    min = s;
                }else if(min.length() == s.length() && map.get(min).get(0) > map.get(s).get(0)){
                    min = s;
                }
            }
            return min;
        }

        private TrieNode query(String s, int pos){
            if(pos < 0){
                return null;
            }
            if(pos == 0 || this.nodes[s.charAt(pos-1)-'a'] == null){
                return this;
            }
            TrieNode res = this.nodes[s.charAt(pos-1)-'a'].query(s, pos-1);
            if(res == null){
                return this;
            }
            return res;
        }
    }
}