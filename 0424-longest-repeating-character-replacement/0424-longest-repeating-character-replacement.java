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
            
            int length = (end-start+1);
            
            
            if(start<end && k+maxCount<length){
                char startChar=s.charAt(start);
                count.put(startChar,count.get(startChar)-1);
                if(count.get(startChar)==0){
                    count.remove(startChar);
                }
                start++;
                
            }
            res=Math.max(res,end-start+1);
            end++;
        }
        return res;
    }
}