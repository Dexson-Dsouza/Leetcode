class Solution {
    public int countSubstrings(String s) {
        char[] strArr= s.toCharArray();
        int len = s.length();
        Boolean[][] isPal = new Boolean[len][len];
        
        for(int i=0;i<len;i++){
            isPal[i][i]=true;
        }
        for(int i=0;i<len-1;i++){
            isPal[i][i+1]= strArr[i]==strArr[i+1]?true:false;
        }
        
        for(int l=2;l<len;l++){
            for(int i=0;i+l<len;i++){
                int j = i+l;
                if(strArr[i] == strArr[j] && isPal[i+1][j-1]){
                    isPal[i][j] = true;
                }else{
                    isPal[i][j] = false;
                }
            }
        }
        
        int count = 0;
        for(int i=0;i<len;i++){
            for(int j=i;j<len;j++){
                if(isPal[i][j]){
                    count++;
                }
            }
        }
        return count;
    }
}