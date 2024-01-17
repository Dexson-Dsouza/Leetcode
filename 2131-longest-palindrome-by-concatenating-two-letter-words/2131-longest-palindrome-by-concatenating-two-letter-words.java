class Solution {
    public int longestPalindrome(String[] words) {
        Map<String,Integer> count_map = new HashMap<>();
        
        for(String w:words){
            count_map.put(w,count_map.getOrDefault(w,0)+1);
        }
        boolean middle_taken=false;
        int count = 0;
        for(String word:words){
            String reverse_word = new StringBuilder(word).reverse().toString();
            
            if(word.equals(reverse_word)){
                int word_count = count_map.get(word);
                int word_used = word_count;
                if(word_used%2==1){
                    word_used--;
                }
                
                count += word_used*2;
                word_count -= word_used;
                
                if(!middle_taken && word_count%2==1){
                    word_count--;
                    middle_taken = true;
                    count +=2;
                }
                
                count_map.put(word,word_count);
            }else{
                int cnt1 = count_map.getOrDefault(word,0);
                int cnt2 = count_map.getOrDefault(reverse_word,0);
                
                int word_used = Math.min(cnt1,cnt2);
                count += word_used*4;
                
                count_map.put(word,cnt1 -word_used );
                count_map.put(reverse_word,cnt2 -word_used );
            }
            
        }
        return count;
    }
}