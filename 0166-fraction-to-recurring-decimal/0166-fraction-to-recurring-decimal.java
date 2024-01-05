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
            num = (r*10);
            if(digitIndexMap.containsKey(num)){
                res.insert(digitIndexMap.get(num)-1, "(");
                res.append(")");
                break;
            }
            q = num/dem;
            r = num%dem;
            res.append(q);
            digitIndexMap.put(num,res.length());
            // System.out.println(q+" "+r+" "+res+" " +num+" "+dem );
        }
        return res.toString();
    }
}