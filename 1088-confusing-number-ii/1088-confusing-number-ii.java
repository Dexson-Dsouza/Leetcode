class Solution {
    public int confusingNumberII(int n) {
        int[] validDigits = new int[]{1,6,8,9,0};
        int count = 0;
        for(int i=0;i<4;i++){
            count += getconfusingNumber(validDigits[i],n,validDigits);
        }
        return count;
    }
    
    public int getconfusingNumber(int cur, int limit, int[] validDigits){
        int countOfConfusingNums = 0;
        if(check(cur)){
            // System.out.println(cur);
            countOfConfusingNums++;
        }
        
        for(int d:validDigits){
            if(cur<= (limit-d)/10){
                countOfConfusingNums+= getconfusingNumber(cur*10 + d, limit,validDigits);
            }
        }
        return countOfConfusingNums;
    }
    
    public boolean check(int num){
        int original = num;
        int reversedNum = 0;
        while(num!=0){
            int digit = num%10;
            num/=10;
            int reversedDigit;
            if(digit==6){
                reversedDigit = 9;
            }else if(digit==9){
                reversedDigit = 6;
            }else{
                reversedDigit = digit;
            }
            reversedNum = reversedNum * 10 +reversedDigit;
        }
        // System.out.println(original+" "+reversedNum);
        return reversedNum != original;
    }
}