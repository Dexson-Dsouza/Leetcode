class Solution {
    public int minDeletions(String s) {
        int[] freq=new int[26];
        for(char ch:s.toCharArray()){
            freq[ch-'a']++;
        }
        
        int totalDeleteOperations=0;
        
        Set<Integer> charFreqs=new HashSet<>();
        for(int ch=0;ch<26;ch++){
            if(freq[ch]==0){
                continue;
            }
            int curFreq=freq[ch];
            int deleteOperations=0;
            while(curFreq>0 && charFreqs.contains(curFreq)){
                curFreq--;
                deleteOperations++;
            }
            charFreqs.add(curFreq);
            totalDeleteOperations+=deleteOperations;
        }
        return totalDeleteOperations;
    }
}