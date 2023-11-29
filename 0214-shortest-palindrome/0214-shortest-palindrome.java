class Solution {
    public String shortestPalindrome(String s) {
        int end = s.length() - 1;
        char chs[] = s.toCharArray();
       
        while(end>=0){
            
            int i=0;
            int j=end;
            boolean isPal = true;
            while(i<j){
                if(chs[i]==chs[j]){
                    i++;
                    j--;
                }else{
                    isPal = false;
                    break;
                }
            }
            if(isPal){
                break;
            }else{
                end--;
            }
        }
        
        StringBuilder extraString = new StringBuilder(s.substring(end+1));
        
        return extraString.reverse().toString() + s;
    }
}