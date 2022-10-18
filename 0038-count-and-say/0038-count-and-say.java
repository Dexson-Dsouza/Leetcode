class Solution {
    public String countAndSay(int n) {
        String num="1";
        while(n>1){
            StringBuilder nextNum=new StringBuilder();
            int i=0;
            int len=num.length();
            while(i<len){
                char curDigit=num.charAt(i);
                int count=0;
                while(i<len && curDigit==num.charAt(i)){
                    i++;
                    count++;
                }
                nextNum.append(count);
                nextNum.append(curDigit);
                
            }
            num=nextNum.toString();
            n--;
        }
        return num;
    }
}