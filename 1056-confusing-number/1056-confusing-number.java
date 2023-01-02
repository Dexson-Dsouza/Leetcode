class Solution {
    public boolean confusingNumber(int n) {
        Map<Integer,Integer> reverseDigitMap=new HashMap<>();
        reverseDigitMap.put(6,9);
        reverseDigitMap.put(9,6);
        reverseDigitMap.put(8,8);
        reverseDigitMap.put(1,1);
        reverseDigitMap.put(0,0);
        int reversedNum = 0;
        int originalNum = n;
        while(n!=0){
            int digit = n%10;
            if(reverseDigitMap.containsKey(digit)==false){
                return false;
            }
            reversedNum = reversedNum * 10 + reverseDigitMap.get(digit);
            n/=10;
        }
        return !(reversedNum==originalNum);
    }
}