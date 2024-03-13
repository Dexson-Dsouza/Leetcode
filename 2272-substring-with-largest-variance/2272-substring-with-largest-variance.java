class Solution {
    public int largestVariance(String s) {
        int maxVariance=0;      
        int[] count=new int[26];
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)-'a']++;
        }
        
        
        for(int a=0;a<26;a++){
            for(int b=0;b<26;b++){
                
                int countA= count[a];
                int countB= count[b];
                if(countA==0 || countB==0 ||a==b){
                    continue;
                }
                
                int freqA=0;
                int freqB=0;
                
                for(char c:s.toCharArray()){
                    int ch= c-'a';
                    if(ch==a){
                        freqA++;
                    }
                    if(ch==b){
                        countB--;
                        freqB++;
                    }
                    if(freqB>0 && freqA>0){
                        maxVariance=Math.max(maxVariance,freqA-freqB);
                    }
                    
                    if(freqB>freqA && countB>0){
                        freqB=freqA=0;
                    }
                }
                
            }
        }
        return maxVariance;
    }
}