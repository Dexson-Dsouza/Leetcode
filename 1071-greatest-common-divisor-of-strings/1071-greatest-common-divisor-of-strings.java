class Solution {
    public String gcdOfStrings(String str1, String str2) {
        String smallestStr = "";
        int l1 = str1.length();
        int l2 = str2.length();
        if(l1<l2){
            smallestStr = str1;
        }else{
            smallestStr = str2;
        }
        
        int len = smallestStr.length();
        
        for(int i=len;i>=0;i--){
            int curLen = i + 1;
            if(l1%curLen == 0  && l2%curLen == 0){
                String curString = smallestStr.substring(0,i+1);
                StringBuilder temp1 = new StringBuilder();
                while(temp1.length()!=l1){
                    temp1.append(curString);
                }
                
                StringBuilder temp2 = new StringBuilder();
                while(temp2.length()!=l2){
                    temp2.append(curString);
                }
                
                if(temp1.toString().equals(str1) && temp2.toString().equals(str2)){
                    return curString;
                }
            }
        }
        return "";
    }
}