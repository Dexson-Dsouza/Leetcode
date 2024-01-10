class Solution {
    public int longestPalindrome(String[] words) {
        int wordCount=words.length;
        
        int longestLen=0;
        boolean singlePalTaken=false;
        
        Map<String,Integer> count=new HashMap<>();
        for(int i=0;i<wordCount;i++){
            count.put(words[i],count.getOrDefault(words[i],0)+1);
        }
        
        Set<String> processed=new HashSet<>();
        System.out.println(count);
        for(String word:count.keySet()){
            String reverse= new StringBuilder(word).reverse().toString();
            
            if(processed.contains(word) || processed.contains(reverse)){
                continue;
            }
            processed.add(word);
            processed.add(reverse);
            if(word.equals(reverse)){
                int totalCount = count.get(word);
                int maxTaken = totalCount - totalCount%2;
                longestLen += maxTaken*2;
                if(totalCount%2==1 && singlePalTaken==false){
                    singlePalTaken=true;
                    longestLen+=2;
                }
            }else{
                int count1=count.getOrDefault(word,0);
                int count2=count.getOrDefault(reverse,0);
                int maxTaken= Math.min(count1,count2);
                if(maxTaken>0){
                    longestLen += maxTaken*(4);
                }
            }
            // System.out.println(word+" "+reverse+" "+longestLen);
        }
        
        return longestLen;
    }
}