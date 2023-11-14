class Solution {
    public int countPalindromicSubsequence(String s) {
        int[] leftCount = new int[26];
        int[] rightCount = new int[26];
        
        for(int i=0;i<s.length();i++){
            char cur= s.charAt(i);
            rightCount[cur-'a']++;
        }
        
        Set<String> palindromes = new HashSet<>();
        
        for(int i=0;i<s.length();i++){
            char cur= s.charAt(i);
            int curIndex = cur-'a';
            rightCount[cur-'a']--;
            for(int characterIndex=0;characterIndex<26;characterIndex++){
                int palCount = Math.min(leftCount[characterIndex],rightCount[characterIndex]);
                if(palCount>0){
                    palindromes.add(characterIndex+"_"+curIndex+"_"+characterIndex);
                }
            }
            leftCount[cur-'a']++;
        }
        return palindromes.size();
    }
}