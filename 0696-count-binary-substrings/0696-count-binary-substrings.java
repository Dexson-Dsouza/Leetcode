class Solution {
    public int countBinarySubstrings(String s) {
        int cntOne= 0;
        int cntZero = 0;
        int count = 0;
        for(int i=0;i<s.length();i++){
            char cur = s.charAt(i);
            if(i>0 && cur!=s.charAt(i-1)){
                if(cur=='1'){
                    cntOne = 0;
                }else{
                    cntZero = 0;
                }
            }
            if(cur=='1'){
                cntOne++;
                if(cntOne<=cntZero){
                    count++;
                }
            }else{
                cntZero++;
                if(cntZero<=cntOne){
                    count++;
                }
            }
        }
        return count;
    }
}