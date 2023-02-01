class Solution {
    public String gcdOfStrings(String str1, String str2) {
        StringBuilder t=new StringBuilder();
        String res="";
        for(char c:str2.toCharArray()){
            t.append(c);
            StringBuilder t1=new StringBuilder();
            while(t1.length()<str1.length()){
                t1.append(t.toString());
            }
            StringBuilder t2=new StringBuilder();
            while(t2.length()<str2.length()){
                t2.append(t.toString());
            }
            if(t1.toString().equals(str1) && t2.toString().equals(str2)){
                res = t.toString();
            }
        }
        return res;
    }
}