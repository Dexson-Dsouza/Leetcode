class Solution {
    public int myAtoi(String s) {
        boolean negative=false;
        s=s.trim();
        int startIndex=0;
        if(s.length()==0){
            return 0;
        }
        if(s.charAt(0)=='-'|| s.charAt(0)=='+'){
            startIndex++;
            negative = s.charAt(0)=='-';
        }
        
        char[] str=s.toCharArray();
        long num=0;
        while(startIndex<str.length && str[startIndex]>='0' && str[startIndex]<='9' && num<Integer.MAX_VALUE){
            num = num * 10 + (str[startIndex]-'0');
            startIndex++;
        }
        
        if(negative==true){
            num*=-1;
            num = Math.max(Integer.MIN_VALUE,num);
        }else{
            num = Math.min(Integer.MAX_VALUE,num);
        }
        // System.out.println(num);
        return (int)(num);
    }
}