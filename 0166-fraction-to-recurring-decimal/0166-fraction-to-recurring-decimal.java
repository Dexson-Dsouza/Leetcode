class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        
        StringBuilder res = new StringBuilder();
        if(numerator==0){
            return "0";
        }
        if((numerator>0 && denominator<0) || (numerator<0 && denominator>0)){
            res.append("-");
        }
        Map<Long,Integer> digitIndexMap=new HashMap<>();
        long num = Math.abs((long)numerator);
        long dem = Math.abs((long)denominator);
        long q = num/dem;
        long r = num%dem;
        res.append(q);
        if(r!=0)
            res.append('.');
        while(r!=0){
            r = (r*10);
            if(digitIndexMap.containsKey(r)){
                res.insert(digitIndexMap.get(r)-1, "(");
                res.append(")");
                break;
            }
            q = r/dem;
            res.append(q);
            digitIndexMap.put(r,res.length());
            r = r%dem;
        }
        return res.toString();
    }
}