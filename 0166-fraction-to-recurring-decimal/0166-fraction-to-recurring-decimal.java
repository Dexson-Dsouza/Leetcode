class Solution {
    public String fractionToDecimal(int n, int d) {
        boolean positive = true;
        if((n>0 && d<0) || (n<0 && d>0)){
            positive=false;
        }
            
        long numerator = Math.abs((long)n);
        long denominator = Math.abs((long)d);
        // System.out.println(numerator+" "+denominator);
        StringBuilder res = new StringBuilder();
        long digit = numerator/denominator;
        res.append(digit);
        numerator = numerator %denominator;
        Map<Long,Integer> digitIndex = new HashMap<>();
        
        if(numerator!=0){
            res.append('.');
        }
        while(numerator!=0){
            numerator*=10;
            digit = numerator/denominator;
            res.append(digit);
            numerator = numerator % denominator;
            if(digitIndex.containsKey(numerator)){
                int startIndex = digitIndex.get(numerator);
                res.insert(startIndex,'(');
                res.append(')');
                break;
            }else{
                digitIndex.put(numerator,res.length());
            }
        }
        if(positive==false){
            res.insert(0,'-');
        }
        return res.toString();
    }
}