class Solution {
    public int longestStrChain(String[] words) {
        Map<String,Integer> map = new HashMap<>();
        
        Arrays.sort(words,(a,b)->a.length()-b.length());
        
        int res=1;
        
        for(String word: words){
            int currLen=1;
            
            for(int i=0;i<word.length();i++){
                String pred="";
                pred+=word.substring(0,i);
                pred+=word.substring(i+1,word.length());
                System.out.println(pred);
                int prevLen=map.getOrDefault(pred,0);
                currLen = Math.max(prevLen+1,currLen);
            }
            map.put(word,currLen);
            res=Math.max(res,currLen);
        }
        return res;
    }
}