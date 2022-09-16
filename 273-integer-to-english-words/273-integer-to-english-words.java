class Solution {
    private final String[] LESS_THAN_20 = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
                                           "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen",
                                           "Seventeen", "Eighteen", "Nineteen"};
    private final String[] TENS = {"Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty",
                                   "Ninety"};
    private final String[] THOUSANDS = {"Thousand", "Million", "Billion"};
    public String numberToWords(int num) {
        String word="";
        int i=0;
        while(num>0){
            if(num%1000!=0)
                word = helper(num%1000) + (i>0?(THOUSANDS[i-1]):"") +" "+ word;
            num/=1000;
            i++;
        }
        word=word.trim();
        if(word.length()==0){
            word="Zero";
        }
        return word;
    }
    
    public String helper(int n){
        if(n==0){
            return "";
        }else if(n<20){
            return LESS_THAN_20[n-1]+ " ";
        }else if(n<100){
            int digit= (n/10);
            return (digit>0?TENS[digit-1]:"") +" "+ helper(n%10);
        }
        else{
            return LESS_THAN_20[(n/100)-1] + " Hundred "+ helper(n%100);
        }
    }
}
