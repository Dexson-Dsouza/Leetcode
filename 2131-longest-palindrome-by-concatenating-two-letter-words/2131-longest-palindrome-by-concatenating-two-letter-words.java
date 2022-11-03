class Solution {
    public int longestPalindrome(String[] words) {
        int wordCount=words.length;
        
        int longestLen=0;
        boolean singlePalTaken=false;
        
        Map<String,Integer> count=new HashMap<>();
        for(int i=0;i<wordCount;i++){
            count.put(words[i],count.getOrDefault(words[i],0)+1);
        }
        // System.out.println(count);
        for(String word:count.keySet()){
            String reverse= new StringBuilder(word).reverse().toString();
            // System.out.println(word + " "+ reverse+" "+longestLen);
            if(word.equals(reverse)){
                int totalCount = count.get(word);
                int maxTaken = totalCount/2;
                longestLen += maxTaken*(word.length()*2);
                int remaining = totalCount - maxTaken*2;
                if(remaining>0 && singlePalTaken==false){
                    singlePalTaken=true;
                    longestLen+=2;
                    remaining--;
                }
                count.put(word,remaining);
            }else{
                int count1=count.getOrDefault(word,0);
                int count2=count.getOrDefault(reverse,0);
                
                int maxTaken= Math.min(count1,count2);
                
                if(maxTaken>0){
                    count.put(word,count.get(word)-maxTaken);
                    count.put(reverse,count.get(reverse)-maxTaken);
                    longestLen += maxTaken*(word.length() + reverse.length());
                }
            }
            
            
            
        }
        
        return longestLen;
    }
    
    public boolean isPal(String s1){
        StringBuilder s2=new StringBuilder(s1);
        return s2.reverse().toString().equals(s1);
    }
}