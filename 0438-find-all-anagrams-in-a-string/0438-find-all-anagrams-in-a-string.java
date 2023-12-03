class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] count=new int[26];
        for(char ch:p.toCharArray()){
            count[ch-'a']++;
        }
        List<Integer> startIndexes=new ArrayList<>();
        int start=0;
        for(int i=0;i<s.length();i++){
            char cur = s.charAt(i);
            count[cur-'a']--;
            while(count[cur-'a']<0){
                char startChar = s.charAt(start);
                start++;
                count[startChar-'a']++;
            }
            
            if(i-start+1 == p.length()){
                startIndexes.add(start);
            }
        }
        return startIndexes;
    }
}