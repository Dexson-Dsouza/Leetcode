class Solution {
    public int countPalindromicSubsequence(String s) {
        int[] left_count = new int[26];
        int[] right_count = new int[26];
        
        for(char ch:s.toCharArray()){
            right_count[ch-'a']++;
        }
        
        int count = 0;
        Set<Integer> done = new HashSet<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            right_count[ch-'a']--;
            for(int character=0;character<26;character++){
                int key = character + (ch-'a')*26 + character*676;
                if(done.contains(key)==false && left_count[character]>0 && right_count[character]>0){
                    count ++;
                    done.add(key);
                }
            }
            left_count[ch-'a']++;
        }
        return count;
    }
}