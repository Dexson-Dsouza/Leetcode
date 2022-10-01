class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Map<Integer,Boolean> dict=new HashMap<>();
        return solve(s,wordDict,dict,0);   
    }
    
    public boolean solve(String s, List<String> wordDict, Map<Integer,Boolean> dict, int index){
        if(s.length()==index){
            return true;
        }
        
        if(dict.containsKey(index)){
            return dict.get(index);
        }
        boolean canMake=false;
        for(String word:wordDict){
            if(index+word.length()>s.length()){
                continue;
            }
            String substr = s.substring(index,index+word.length());
            if(substr.equals(word) && solve(s,wordDict,dict,index+word.length())==true){
                canMake=true;
                break;
            }
        }
        dict.put(index,canMake);
        return canMake;
    }
}