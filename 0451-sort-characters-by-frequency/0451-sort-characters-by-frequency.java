class Solution {
    
    static class charCountPair{
        int count;
        char ch;
        charCountPair(char ch, int count){
            this.ch=ch;
            this.count=count;
        }
    }
    
    public String frequencySort(String s) {
        Map<Character,Integer> charFreqMap=new HashMap<>();
        
        for(char ch:s.toCharArray()){
            charFreqMap.put(ch,charFreqMap.getOrDefault(ch,0)+1);
        }
        
        List<charCountPair> charCountList=new ArrayList<>();
        
        for(char ch:charFreqMap.keySet()){
            charCountList.add(new charCountPair(ch,charFreqMap.get(ch)));
        }
        Collections.sort(charCountList, new Comparator<charCountPair>(){
            public int compare(charCountPair a, charCountPair b){
                return b.count-a.count;
            }
        });
        StringBuilder result=new StringBuilder();
        for(charCountPair pair:charCountList){
            int count=pair.count;
            while(count>0){
                result.append(pair.ch);
                count--;
            }
        }
        
        return result.toString();
    }
}