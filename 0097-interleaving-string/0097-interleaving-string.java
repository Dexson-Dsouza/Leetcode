class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n1=s1.length();
        int n2=s2.length();
        if(n1+n2!=s3.length()){
            return false;
        }
        boolean[][] canMake = new boolean[n1+1][n2+1];
        
        for(int i1=0;i1<=n1;i1++){
            for(int i2=0;i2<=n2;i2++){
                
                if(i1==0 && i2==0){
                    canMake[i1][i2]=true;
                }else if(i1>0 && i2==0){
                    canMake[i1][i2] = s1.charAt(i1-1)==s3.charAt(i1+i2-1) && canMake[i1-1][i2];
                }else if(i2>0 && i1==0){
                    canMake[i1][i2] = s2.charAt(i2-1)==s3.charAt(i1+i2-1) && canMake[i1][i2-1];
                }else{
                    canMake[i1][i2] = 
                        (s1.charAt(i1-1)==s3.charAt(i1+i2-1) && canMake[i1-1][i2]) 
                        ||
                        (s2.charAt(i2-1)==s3.charAt(i1+i2-1) && canMake[i1][i2-1]);
                }
                
            }    
        }
        return canMake[n1][n2];
    }
}