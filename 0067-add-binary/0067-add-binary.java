class Solution {
    public String addBinary(String a, String b) {
        int i=a.length()-1;
        int j=b.length()-1;
        int carry=0;
        
        StringBuilder res=new StringBuilder();
        while(i>=0 && j>=0){
            int sum = (a.charAt(i)-'0')+(b.charAt(j)-'0')+carry;
            if((sum&1)!=0){
                res.append('1');
            }else{
                res.append('0');
            }
            
            carry = (sum&2)!=0?1:0;
            i--;
            j--;
        }
        
        while(i>=0){
            int sum = (a.charAt(i)-'0')+carry;
            if((sum&1)!=0){
                res.append('1');
            }else{
                res.append('0');
            }
            
            carry = (sum&2)!=0?1:0;
            i--;
        }
        while(j>=0){
            int sum = (b.charAt(j)-'0')+carry;
            if((sum&1)!=0){
                res.append('1');
            }else{
                res.append('0');
            }
            
            carry = (sum&2)!=0?1:0;
            j--;
        }
        if(carry==1){
            res.append('1');
        }
        res.reverse();
        return res.toString();
    }
}