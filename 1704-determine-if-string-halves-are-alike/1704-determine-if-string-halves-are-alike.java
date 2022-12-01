class Solution {
    public boolean halvesAreAlike(String s) {
        Set<Character> vowels=new HashSet<>();
        vowels.add('a');
        vowels.add('A');
        vowels.add('e');
        vowels.add('E');
        vowels.add('i');
        vowels.add('I');
        vowels.add('o');
        vowels.add('O');
        vowels.add('U');
        vowels.add('u');
        
        int len = s.length();
        int cnt=0;
        for(int i=0;i<len;i++){
            if(vowels.contains(s.charAt(i))){
                if(i<len/2){
                    cnt++;
                }else{
                    cnt--;
                }
            }
        }
        return cnt==0;
    }
}