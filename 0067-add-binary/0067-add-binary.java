class Solution {
    public String addBinary(String a, String b) {
        int carry = 0;
        int i1=a.length()-1;
        int i2=b.length()-1;
        StringBuilder sumStr= new StringBuilder();
        
        while(i1>=0 || i2>=0){
            int aBit = i1>=0 ? a.charAt(i1)-'0':0;
            int bBit = i2>=0 ? b.charAt(i2)-'0':0;
            int sum = aBit+bBit+carry;
            carry = sum/2;
            sum = sum%2;
            sumStr.append(sum);
            i1--;
            i2--;
        }
        if(carry!=0){
            sumStr.append(carry);
        }
        return sumStr.reverse().toString();
    }
}