class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Map<String,Boolean> dict=new HashMap<>();
        return solve(s,wordDict,dict);   
    }
    
    public boolean solve(String s, List<String> wordDict, Map<String,Boolean> dict){
        if(s.length()==0){
            return true;
        }
        
        if(dict.containsKey(s)){
            return dict.get(s);
        }
        boolean canMake=false;
        for(String word:wordDict){
            if(s.startsWith(word) && solve(s.substring(word.length()),wordDict,dict)==true){
                canMake=true;
                break;
            }
        }
        dict.put(s,canMake);
        return canMake;
    }
}