class Solution {
    public String reverseByType(String s) {
        char[] arr = s.toCharArray();
        int n = s.length();

        int lowerStart = 0;
        int lowerEnd = n-1;

        int specialStart = 0;
        int specialEnd = n-1;

        while (lowerEnd > lowerStart){
            while (lowerStart < n && !Character.isLetterOrDigit(s.charAt(lowerStart))){
                lowerStart++;
            }
            while (lowerEnd > 0 && !Character.isLetterOrDigit(s.charAt(lowerEnd))) {
                lowerEnd--;
            }

            if(lowerStart < lowerEnd){
                char temp = s.charAt(lowerStart);
                arr[lowerStart] = arr[lowerEnd];
                arr[lowerEnd] = temp;
                lowerStart++;
                lowerEnd--;
            }
        }

        while (specialStart < specialEnd){
            while (specialStart < n && Character.isLetterOrDigit(s.charAt(specialStart)))
                specialStart++;
            while (specialEnd > 0 && Character.isLetterOrDigit(s.charAt(specialEnd)))
                specialEnd--;

            if(specialStart < specialEnd){

                char temp = arr[specialStart];
                arr[specialStart] = arr[specialEnd];
                arr[specialEnd] = temp;
                specialStart++;
                specialEnd--;
            }
        }
        return new String(arr);
    }
}