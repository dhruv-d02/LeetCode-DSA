class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if(!(str1+str2).equals(str2+str1)){
            return "";
        }
        String common = "";
        int pos = str1.length() >= str2.length() ? str2.length() - 1 : str1.length() - 1;
        boolean sub = str1.length() >= str2.length() ? true : false;
        while (pos >= 0) {
            StringBuilder check = new StringBuilder();
            String substr = new String();
            if (sub) {
                substr = str2.substring(0, pos + 1);
                
            } else {
                substr = str1.substring(0, pos + 1);
            }
            boolean valid1 = false;
            boolean valid2 =  false;
            while (check.length() < str1.length() || check.length() < str2.length()){
                check.append(substr);
                if(check.toString().equals(str1)){
                    valid1 = true;
                }
                if(check.toString().equals(str2)){
                    valid2 = true;
                }
            }
            if(check.toString().equals(str1)){
                valid1 = true;
            }
            if(check.toString().equals(str2)){
                valid2 = true;
            }
            if(valid2 && valid1){
                return substr;
            }
            pos--;
        }
        return "";
    }
}