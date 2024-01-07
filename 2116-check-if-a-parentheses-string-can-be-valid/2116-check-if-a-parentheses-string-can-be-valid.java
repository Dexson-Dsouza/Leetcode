class Solution {
    public boolean canBeValid(String s, String locked) {
        int free=0,l=0;        
        // l to r balance )
        if(s.length()%2==1){
            return false;
        }
        for(int i=0;i<s.length();i++){
            if(locked.charAt(i)=='0'){
                free++;
            }else if(s.charAt(i)=='('){
                l++;
            }else{
                //balance
                if(l>0){
                    l--;
                }else if (free>0){
                    free--;
                }else{
                    return false;
                }
            }
        }
         // r to l balance (
        free=0;
        int r=0;
        for(int i=s.length()-1;i>=0;i--){
            if(locked.charAt(i)=='0'){
                free++;
            }else if(s.charAt(i)==')'){
                r++;
            }else{
                //balance
                if(r>0){
                    r--;
                }else if (free>0){
                    free--;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}