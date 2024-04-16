class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] isPossible=new Boolean[s.length()];
        return check(s,new HashSet<>(wordDict),isPossible,0);
    }
    
    boolean check(String s, Set<String> words, Boolean[] isPossible, int i){
        if(i==s.length()){
            return true;
        }
        
        if(isPossible[i]!=null){
            return isPossible[i];
        }
        boolean canMake=false;
        for(int index=i+1;index<=s.length();index++){
            if(words.contains(s.substring(i,index))){
                canMake=canMake || check(s,words,isPossible,index);
            }
        }
        isPossible[i]=canMake;
        return canMake;
    }
}