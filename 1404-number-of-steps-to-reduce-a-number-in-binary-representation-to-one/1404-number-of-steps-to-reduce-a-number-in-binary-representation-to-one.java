class Solution {
    public int numSteps(String s) {
        if(s.equals("1")){
            return 0;
        }
        
        int len=s.length();
        if(s.charAt(len-1)=='1'){
            s=addOne(s);
        }else{
            s= s.substring(0,len-1);    
        }
        return 1+numSteps(s);
    }
    
    public String addOne(String s){
        StringBuilder n1=new StringBuilder(s);
        StringBuilder n2=new StringBuilder("1");
        StringBuilder sum=new StringBuilder();
        int i=n1.length()-1;
        int j=n2.length()-1;
        int carry=0;
        while(i>=0 || j>=0 || carry>0){
            int t1=0;
            if(i>=0){
                t1= n1.charAt(i)-'0';
                i--;
            }
            int t2=0;
            if(j>=0){
                t2= n2.charAt(j)-'0';
                j--;
            }
            int digitSum = t1+t2+carry;
            char digit='0';
            digit+= digitSum%2;
            carry=digitSum/2;
            sum.append(digit);
        }
        sum.reverse();
        return sum.toString();
    }
}