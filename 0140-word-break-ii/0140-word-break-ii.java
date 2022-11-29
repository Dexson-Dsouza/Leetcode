class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> words=new HashSet<>(wordDict);
        
        List<String> perms=new ArrayList<>();
        List<String> result=new ArrayList<>();
        generatePermutaions(s,0,words,perms,result);
        return result;
    }
    
    public void generatePermutaions(String s, int index, Set<String> words, List<String> perms,
                                    List<String> result){
        // System.out.println(index+" "+perms);
        if(index == s.length()){
            StringBuilder sentence=new StringBuilder();
            for(int i=0;i<perms.size()-1;i++){
                sentence.append(perms.get(i)+" ");
            }
            sentence.append(perms.get(perms.size()-1));
            // System.out.println(sentence.toString());
            result.add(sentence.toString());
            return;
        }
        
        for(String word:words){
            if(index+word.length()<=s.length() && s.substring(index,index+word.length()).equals(word)){
                perms.add(word);
                generatePermutaions(s,index+word.length(),words,perms,result);
                perms.remove(perms.size()-1);
            }
        }
    }
}