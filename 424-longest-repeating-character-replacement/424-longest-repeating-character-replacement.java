class Solution {
    public int characterReplacement(String s, int k) {
        int start=0;
        int end=0;
        int len=s.length();
        Map<Character,Integer> count=new HashMap<>();
        int res=0;
        while(end<len){
            char ch=s.charAt(end);
            count.put(ch,count.getOrDefault(ch,0)+1);
            
            int maxCount=0;
            for(char c:count.keySet()){
                maxCount=Math.max(maxCount,count.get(c));
            }
            
            int extraCount = (end-start+1 - maxCount);
            
            
            while(start<end && extraCount>k){
                char startChar=s.charAt(start);
                count.put(startChar,count.get(startChar)-1);
                if(count.get(startChar)==0){
                    count.remove(startChar);
                }
                start++;
                maxCount=0;
                for(char c:count.keySet()){
                    maxCount=Math.max(maxCount,count.get(c));
                }
                extraCount = (end-start+1 - maxCount);
                
            }
            res=Math.max(res,end-start+1);
            end++;
        }
        return res;
    }
}