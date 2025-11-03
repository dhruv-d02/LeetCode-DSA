class Solution {
    public boolean isValid(String s) {
        Stack<String> st = new Stack<String>();
        String x = "";
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            switch(c){
                case '(':
                st.push("(");
                break;
                case '{':
                st.push("{");
                break;
                case '[':
                st.push("[");
                break;
                case ')':
                if(st.isEmpty()){
                    return false;
                }
                x = st.pop();
                if(x == "("){
                    //continue;
                }else{
                    return false;
                }
                break;
                case '}':
                if(st.isEmpty()){
                    return false;
                }
                x = st.pop();
                if(x == "{"){
                    //continue;
                }else{
                    return false;
                }
                break;
                case ']':
                if(st.isEmpty()){
                    return false;
                }
                x = st.pop();
                if(x == "["){
                    // continue;
                }else{
                    return false;
                }
                break;
                
            }
        }
        if(!st.isEmpty()){
            return false;
        }
        return true;
    }
}