class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int start=0;
        int end=0;
        int len=s.length();
        Map<Character,Integer> count=new HashMap<>();
        int res=0;
        while(end<len){
            char ch=s.charAt(end);
            count.put(ch,count.getOrDefault(ch,0)+1);
            if(count.get(ch)==1){
                k--;
            }
            while(k<0){
                char startChar=s.charAt(start);
                count.put(startChar,count.get(startChar)-1);
                if(count.get(startChar)==0){
                    k++;
                }
                start++;
            }
            res=Math.max(res,end-start+1);
            end++;
        }
        return res;
    }
}