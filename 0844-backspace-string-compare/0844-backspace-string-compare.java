class Solution {
    public boolean backspaceCompare(String s, String t) {
        String s1="";
        String s2="";
        
        for(char ch:s.toCharArray()){
            if(ch=='#'){
                if(s1.length()>0)
                    s1=s1.substring(0,s1.length()-1);            
            }else{
                s1+=ch;
            }
        }
        
        for(char ch:t.toCharArray()){
            if(ch=='#'){
                if(s2.length()>0)
                    s2=s2.substring(0,s2.length()-1);            
            }else{
                s2+=ch;
            }
        }
        return s1.equals(s2);
    }
}