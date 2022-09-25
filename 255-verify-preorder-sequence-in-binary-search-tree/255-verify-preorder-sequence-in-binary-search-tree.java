class Solution {
    public boolean verifyPreorder(int[] preorder) {
        int i=0;
        
        int lowest=Integer.MIN_VALUE;
        
        for(int n:preorder){
            if(n<lowest){
                return false;
            }
            
            while(i>0 && n>preorder[i-1]){
                lowest=preorder[i-1];
                i--;
            }
            preorder[i]=n;
            i++;
        }
        return true;
    }
}