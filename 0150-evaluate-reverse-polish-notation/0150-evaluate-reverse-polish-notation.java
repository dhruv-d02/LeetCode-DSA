class Solution {
    public int evalRPN(String[] tokens) {
        List<Integer> list = new ArrayList<Integer>();
        int i = 0;
        int n = tokens.length;
        int a =0, b = 0;
        while(i<n){
            String s = tokens[i];
            i++;
            switch(s){
                case "+":
                a = list.get(list.size()-2);
                list.remove(list.size()-2);
                b = list.get(list.size()-1);
                list.remove(list.size()-1);
                list.add(a+b);
                break;
                case "-":
                 a = list.get(list.size()-2);
                list.remove(list.size()-2);
                 b = list.get(list.size()-1);
                list.remove(list.size()-1);
                list.add(a-b);
                break;
                case "*":
                 a = list.get(list.size()-2);
                list.remove(list.size()-2);
                 b = list.get(list.size()-1);
                list.remove(list.size()-1);
                list.add(a*b);
                break;
                case "/":
                 a = list.get(list.size()-2);
                list.remove(list.size()-2);
                 b = list.get(list.size()-1);
                list.remove(list.size()-1);
                list.add(a/b);
                break;
                default:
                list.add(Integer.parseInt(s));
                break;
            }
        }
        return list.get(0);
    }
}