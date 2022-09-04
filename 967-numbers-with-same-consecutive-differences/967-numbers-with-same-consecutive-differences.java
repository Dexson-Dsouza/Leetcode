class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> nums=new ArrayList<>();
        for(int i=1;i<=9;i++){
            generateNums(n-1,k,i,i,nums);
        }
        
        int[] numsArr=new int[nums.size()];
        for(int i=0;i<nums.size();i++){
            numsArr[i]=nums.get(i);
        }
        return numsArr;
    }
    
    void generateNums(int rem, int diff, int cur, int digit, List<Integer> nums){
        if(rem==0){
            nums.add(cur);
            return;
        }
        
        if(digit+diff<=9){
            int nextDigit=digit+diff;
            int nextNum= cur *10 + (nextDigit);
            generateNums(rem-1,diff,nextNum,nextDigit,nums);
        }
        if(diff>0 && digit-diff>=0){
            int nextDigit=digit-diff;
            int nextNum= cur *10 + (nextDigit); 
            generateNums(rem-1,diff,nextNum,nextDigit,nums);
        }
    }
}