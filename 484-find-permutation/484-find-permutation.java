class Solution {
    public int[] findPermutation(String s) {
        int[] perm=new int[s.length()+1];
        
        int curIndex=0;
        for(int i=0;i<=s.length();i++){
            perm[i]=i+1;
        }
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='I'){
                int end=i;
                while(end>curIndex){
                    int t=perm[curIndex];
                    perm[curIndex]=perm[end];
                    perm[end]=t;
                    end--;
                    curIndex++;
                }
                curIndex=i+1;
            }
        }
        int end=s.length();
        while(end>curIndex){
            int t=perm[curIndex];
            perm[curIndex]=perm[end];
            perm[end]=t;
            end--;
            curIndex++;
        }
        
        return perm;
    }
}