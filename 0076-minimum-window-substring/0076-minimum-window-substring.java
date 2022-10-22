class Solution {
    public String minWindow(String s, String t) {
        int[] countT=new int[128];
        int start=0;
        int end=s.length()+1;
        
        int slowIndex=0;
        int fastIndex=0;
        
        for(char c:t.toCharArray()){
            countT[c]++;
        }
        
        int[] countS=new int[128];
        char[] sArr=s.toCharArray();
        
        while(fastIndex<s.length()){
            char cur=sArr[fastIndex];
            
            int charIndex=cur;
            countS[charIndex]++;
            
            while( slowIndex<fastIndex && countS[sArr[slowIndex]]>countT[sArr[slowIndex]]){
                countS[sArr[slowIndex]]--;
                slowIndex++;
            }
            
            boolean found=true;
            for(int i=0;i<128;i++){
                if(countS[i]<countT[i]){
                    found=false;
                    break;
                }
            }
            
            if(found){
                int curLen=fastIndex-slowIndex+1;
                int resultLen=end-start+1;
                if(curLen<resultLen){
                    start=slowIndex;
                    end=fastIndex;
                }
            }
            fastIndex++;
        }
        int resultLen=end-start+1;
        if(resultLen<=s.length()){
            return s.substring(start,end+1);
        }
        return "";
    }
}